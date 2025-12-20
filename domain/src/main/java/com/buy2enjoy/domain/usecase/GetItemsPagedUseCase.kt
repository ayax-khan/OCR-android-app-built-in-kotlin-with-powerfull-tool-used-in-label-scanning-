package com.buy2enjoy.domain.usecase

import androidx.paging.PagingData
import com.buy2enjoy.domain.model.ReturnItem
import com.buy2enjoy.domain.model.ReturnStatus
import com.buy2enjoy.domain.repository.ReturnRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsPagedUseCase @Inject constructor(
    private val repository: ReturnRepository
) {
    data class Params(
        val query: String?,
        val monthYear: String?,
        val status: ReturnStatus?,
        val pageSize: Int = 50
    )

    operator fun invoke(params: Params): Flow<PagingData<ReturnItem>> =
        repository.pagedItems(params.query, params.monthYear, params.status, params.pageSize)
}
