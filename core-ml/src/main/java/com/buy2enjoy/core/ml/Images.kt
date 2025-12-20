package com.buy2enjoy.core.ml

import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage

fun ImageProxy.asInputImage(): InputImage? = image?.let { InputImage.fromMediaImage(it, imageInfo.rotationDegrees) }
