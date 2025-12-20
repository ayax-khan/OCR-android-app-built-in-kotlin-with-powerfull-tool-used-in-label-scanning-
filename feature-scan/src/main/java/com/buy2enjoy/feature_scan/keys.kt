package com.buy2enjoy.feature_scan

import androidx.compose.ui.input.key.KeyEvent

// Attempt to recover typed char from KeyEvent. For barcode wedges, key events usually carry unicodeChar.
fun KeyEvent.utfCharOrNull(): Char? {
    return try {
        // androidx.compose.ui.input.key.KeyEvent wraps native
        val native = this.nativeKeyEvent
        val ch = native.unicodeChar
        if (ch == 0) null else ch.toChar()
    } catch (_: Throwable) {
        null
    }
}
