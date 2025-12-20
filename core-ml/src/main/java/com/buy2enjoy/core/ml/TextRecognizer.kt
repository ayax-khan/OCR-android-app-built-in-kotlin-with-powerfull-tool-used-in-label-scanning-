package com.buy2enjoy.core.ml

import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.tasks.await

class TextRecognizer {
    private val recognizer by lazy { TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS) }

    suspend fun recognize(image: InputImage): Text = recognizer.process(image).await()

    data class Extracted(
        val trackingNumber: String?,
        val orderNumber: String?,
        val createdDateDisplay: String?
    )

    fun extract(text: Text): Extracted {
        val full = text.text
        val tn = Regex("(?i)(?:AWB|Tracking)[:\\n\\s\\-]*([A-Z0-9]{6,})").find(full)?.groupValues?.getOrNull(1)
        val order = Regex("(?i)(?:Order|Ref(erence)?)[:\\n\\s\\-]*([A-Z0-9\\-]{5,})").find(full)?.groupValues?.getOrNull(2)
            ?: Regex("(?i)(?:Order|Ref(erence)?)[:\\n\\s\\-]*([A-Z0-9\\-]{5,})").find(full)?.groupValues?.getOrNull(1)
        val date = Regex("(?i)(?:Date|Created)[:\\n\\s\\-]*([0-3]?\\d\\s+[A-Za-z]{3}\\s+\\d{4})").find(full)?.groupValues?.getOrNull(1)
        return Extracted(trackingNumber = tn, orderNumber = order, createdDateDisplay = date)
    }
}
