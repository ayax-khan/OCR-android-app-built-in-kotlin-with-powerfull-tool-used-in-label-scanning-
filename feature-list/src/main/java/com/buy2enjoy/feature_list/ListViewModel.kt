package com.buy2enjoy.feature_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.usecase.GetItemsPagedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getItemsPaged: GetItemsPagedUseCase
) : ViewModel() {

    data class Filter(
        val query: String? = null,
        val monthYear: String? = null,
        val status: ReturnStatus? = null,
    )

    private val _filter = MutableStateFlow(Filter())
    val filter: StateFlow<Filter> = _filter

    val items: StateFlow<PagingData<ReturnItem>> = _filter
        .flatMapLatest { f ->
            getItemsPaged(
                GetItemsPagedUseCase.Params(
                    query = f.query,
                    monthYear = f.monthYear,
                    status = f.status,
                    pageSize = 50
                )
            )
        }
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    fun setQuery(q: String) { _filter.value = _filter.value.copy(query = q.ifBlank { null }) }
    fun setMonth(m: String?) { _filter.value = _filter.value.copy(monthYear = m?.ifBlank { null }) }
    fun setStatus(s: ReturnStatus?) { _filter.value = _filter.value.copy(status = s) }
}
