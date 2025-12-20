package com.buy2enjoy.feature_scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val scanAndInsert: ScanAndInsertItemUseCase
) : ViewModel() {

    sealed class UiEvent {
        data class Inserted(val tracking: String): UiEvent()
        data class Duplicate(val tracking: String): UiEvent()
        data class Info(val message: String): UiEvent()
    }

    private val _events = MutableSharedFlow<UiEvent>(extraBufferCapacity = 16)
    val events: SharedFlow<UiEvent> = _events

    fun onBarcode(tracking: String) {
        viewModelScope.launch {
            val res = scanAndInsert(
                ScanAndInsertItemUseCase.Params(
                    trackingNumber = tracking,
                    orderNumber = null,
                    createdDateDisplay = null
                )
            )
            when (res) {
                is ScanAndInsertItemUseCase.Result.Inserted -> _events.emit(UiEvent.Inserted(tracking))
                is ScanAndInsertItemUseCase.Result.Duplicate -> _events.emit(UiEvent.Duplicate(tracking))
                is ScanAndInsertItemUseCase.Result.Invalid -> _events.emit(UiEvent.Info(res.reason))
            }
        }
    }

    fun onOcr(tracking: String?, order: String?, dateDisplay: String?) {
        if (tracking == null && order == null && dateDisplay == null) return
        if (tracking != null) onBarcode(tracking) // prioritize tracking insert
        // Optionally: store order/date into record later via edit flow
    }
}
