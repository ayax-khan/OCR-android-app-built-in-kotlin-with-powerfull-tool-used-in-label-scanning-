package com.buy2enjoy.core.ml

import android.graphics.Rect
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.barcode.common.Barcode.FORMAT_CODE_128
import com.google.mlkit.vision.barcode.common.Barcode.FORMAT_CODE_39
import com.google.mlkit.vision.barcode.common.Barcode.FORMAT_QR_CODE
import com.google.mlkit.vision.common.InputImage
import kotlinx.coroutines.tasks.await

class BarcodeScanner {
    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(FORMAT_CODE_128, FORMAT_CODE_39, FORMAT_QR_CODE)
        .build()

    private val scanner by lazy { BarcodeScanning.getClient(options) }

    suspend fun scan(image: InputImage): List<Barcode> =
        scanner.process(image).await()
}
