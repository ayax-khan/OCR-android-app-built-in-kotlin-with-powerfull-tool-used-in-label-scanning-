package com.buy2enjoy.core.common

import android.os.SystemClock

/**
 * Collects fast keyboard-wedge input from USB/Bluetooth scanners and emits the full scan
 * when ENTER ("\n") is received or when inter-key timeout elapses.
 */
class ScannerInputManager(
    private val onScan: (String) -> Unit,
    private val interKeyTimeoutMs: Long = 60L,
    private val minLength: Int = 4,
) {
    private val buffer = StringBuilder()
    private var lastTs = 0L

    fun reset() {
        buffer.clear()
        lastTs = 0L
    }

    fun onChar(c: Char, isEnter: Boolean = false) {
        val now = SystemClock.elapsedRealtime()
        if (now - lastTs > interKeyTimeoutMs) {
            // Timeout: treat as new scan
            buffer.clear()
        }
        lastTs = now

        if (isEnter) {
            val result = buffer.toString()
            buffer.clear()
            if (result.length >= minLength) onScan(result)
            return
        }
        if (!c.isISOControl()) buffer.append(c)
    }
}
