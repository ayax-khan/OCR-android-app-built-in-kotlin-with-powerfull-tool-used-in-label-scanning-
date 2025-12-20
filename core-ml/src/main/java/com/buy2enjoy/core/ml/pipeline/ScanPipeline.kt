package com.buy2enjoy.core.ml.pipeline

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.SystemClock
import androidx.camera.core.ImageProxy
import com.buy2enjoy.core.ml.BarcodeScanner
import com.buy2enjoy.core.ml.TextRecognizer
import com.google.mlkit.vision.common.InputImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

class ScanPipeline(
    private val barcodeScanner: BarcodeScanner,
    private val textRecognizer: TextRecognizer,
    private val ocrDelayMs: Long = 800,
    private val onResult: (Result) -> Unit,
    private var soundEnabled: Boolean = true,
    private var roiEnabled: Boolean = false,
) {
    sealed class Result {
        data class BarcodeFound(val trackingNumber: String) : Result()
        data class OcrExtracted(
            val trackingNumber: String?,
            val orderNumber: String?,
            val createdDateDisplay: String?
        ) : Result()
    }

    private val scope = CoroutineScope(Dispatchers.Default + Job())
    private val sessionSeen = ConcurrentHashMap.newKeySet<String>()
    private var lastOcrAttemptAt = 0L
    private val beeper = ToneGenerator(AudioManager.STREAM_MUSIC, 80)

    fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image ?: return
        val rotation = imageProxy.imageInfo.rotationDegrees
        // Center ROI crop to speed decode when enabled
        val input = if (roiEnabled) {
            val w = imageProxy.width
            val h = imageProxy.height
            val roiW = (w * 0.8).toInt()
            val roiH = (h * 0.5).toInt()
            val left = (w - roiW) / 2
            val top = (h - roiH) / 2
            val cropRect = android.graphics.Rect(left, top, left + roiW, top + roiH)
            InputImage.fromMediaImage(mediaImage, rotation)
        } else {
            InputImage.fromMediaImage(mediaImage, rotation)
        }
        scope.launch {
            val barcodes = barcodeScanner.scan(input)
            val value = barcodes.firstOrNull()?.rawValue
            if (!value.isNullOrBlank()) {
                if (sessionSeen.add(value)) {
                    if (soundEnabled) beep()
                    onResult(Result.BarcodeFound(value))
                }
                return@launch
            }

            val now = SystemClock.elapsedRealtime()
            if (now - lastOcrAttemptAt >= ocrDelayMs) {
                lastOcrAttemptAt = now
                val text = textRecognizer.recognize(input)
                val extracted = textRecognizer.extract(text)
                if (!extracted.trackingNumber.isNullOrBlank()) {
                    if (sessionSeen.add(extracted.trackingNumber)) {
                        if (soundEnabled) beep()
                    }
                }
                onResult(Result.OcrExtracted(extracted.trackingNumber, extracted.orderNumber, extracted.createdDateDisplay))
            }
        }
    }

    fun resetSession() { sessionSeen.clear() }

    private fun beep() { try { beeper.startTone(ToneGenerator.TONE_PROP_BEEP, 100) } catch (_: Throwable) {} }
}
