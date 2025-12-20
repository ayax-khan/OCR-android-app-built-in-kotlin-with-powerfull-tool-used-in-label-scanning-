package com.buy2enjoy.returnscanner.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buy2enjoy.domain.repository.ReturnRepository
import com.buy2enjoy.domain.usecase.GetStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getStats: GetStatsUseCase
) : ViewModel() {
    val stats: StateFlow<ReturnRepository.Stats> = getStats().stateIn(
        viewModelScope, SharingStarted.Eagerly,
        ReturnRepository.Stats(0,0,0,0)
    )
}
