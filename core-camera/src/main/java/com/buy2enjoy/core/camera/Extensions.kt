package com.buy2enjoy.core.camera

import androidx.camera.core.ImageProxy

val ImageProxy.rotationDegreesCompat: Int get() = imageInfo.rotationDegrees
