package com.buy2enjoy.feature_export

import android.content.ContentResolver
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.usecase.ExportItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ExportViewModel @Inject constructor(
    private val exportItems: ExportItemsUseCase
) : ViewModel() {

    private val _isExporting = MutableStateFlow(false)
    val isExporting: StateFlow<Boolean> = _isExporting

    private val _events = Channel<Event>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    sealed class Event {
        data class Success(val count: Int): Event()
        data class Error(val message: String): Event()
    }

    fun exportMonth(contentResolver: ContentResolver, uri: Uri, monthYear: String) {
        viewModelScope.launch {
            _isExporting.value = true
            try {
                val items = exportItems(monthYear)
                writeCsv(contentResolver, uri, items)
                _events.send(Event.Success(items.size))
            } catch (t: Throwable) {
                _events.send(Event.Error(t.message ?: "Export failed"))
            } finally {
                _isExporting.value = false
            }
        }
    }

    private fun writeCsv(cr: ContentResolver, uri: Uri, items: List<ReturnItem>) {
        cr.openOutputStream(uri)?.use { os ->
            // Write UTF-8 BOM to help Excel recognize encoding
            os.write(byteArrayOf(0xEF.toByte(), 0xBB.toByte(), 0xBF.toByte()))
            OutputStreamWriter(os, StandardCharsets.UTF_8).use { w ->
                w.appendLine("Tracking Number,Order Number,Created Date,Scan Date,Status,Month")
                val zone = ZoneId.of("Asia/Karachi")
                val fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(zone)
                items.forEach { item ->
                    val scanDate = fmt.format(Instant.ofEpochMilli(item.scanDate))
                    w.append(item.trackingNumber)
                    w.append(',')
                    w.append(item.orderNumber ?: "")
                    w.append(',')
                    w.append(item.createdDate ?: "")
                    w.append(',')
                    w.append(scanDate)
                    w.append(',')
                    w.append(item.status.name)
                    w.append(',')
                    w.append(item.monthYear)
                    w.append('\n')
                }
                w.flush()
            }
        } ?: throw IllegalStateException("Unable to open output stream")
    }
}
