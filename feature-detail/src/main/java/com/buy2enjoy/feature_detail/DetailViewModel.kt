package com.buy2enjoy.feature_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import com.buy2enjoy.domain.usecase.MarkStatusUseCase
import com.buy2enjoy.domain.usecase.UpdateItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ReturnRepository,
    private val updateItem: UpdateItemUseCase,
    private val markStatus: MarkStatusUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val itemId: Long = savedStateHandle.get<Long>("id") ?: 0L

    private val _item = MutableStateFlow<ReturnItem?>(null)
    val item: StateFlow<ReturnItem?> = _item

    private val _isSaving = MutableStateFlow(false)
    val isSaving: StateFlow<Boolean> = _isSaving

    init {
        viewModelScope.launch {
            _item.value = repository.getById(itemId)
        }
    }

    fun updateFields(orderNumber: String?, createdDateDisplay: String?) {
        val current = _item.value ?: return
        _item.value = current.copy(
            orderNumber = orderNumber?.ifBlank { null },
            createdDate = createdDateDisplay?.ifBlank { null }
        )
    }

    fun changeStatus(status: ReturnStatus) {
        viewModelScope.launch {
            markStatus(itemId, status)
            // refresh
            _item.value = repository.getById(itemId)
        }
    }

    fun save() {
        val current = _item.value ?: return
        viewModelScope.launch {
            _isSaving.value = true
            try {
                updateItem(current)
            } finally {
                _isSaving.value = false
            }
        }
    }
}
