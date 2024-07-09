package com.ploddasha.cinemashiftapp.schedule.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.ScheduleUiState
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.Seance
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.SelectedData
import com.ploddasha.cinemashiftapp.schedule.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ScheduleViewModel(
    private val filmId: String,
    private val getScheduleUseCase: GetScheduleUseCase,
    private val router: ScheduleRouter
) : ViewModel() {

    private val _state = MutableStateFlow<ScheduleState>(ScheduleState.Initial)
    val state: StateFlow<ScheduleState> = _state

    private val _uiState = MutableStateFlow(ScheduleUiState(SelectedData(filmId = filmId)))
    val uiState: StateFlow<ScheduleUiState> = _uiState.asStateFlow()


    fun setDateAndTime(date: String, time: String) {
        val seance = Seance(date = date, time = time)
        _uiState.update { it.copy(selectedData = it.selectedData?.copy(seance = seance)) }
    }


    fun loadSchedule() {
        if (_state.value is ScheduleState.Content || _state.value is ScheduleState.Loading) {
            return
        }

        viewModelScope.launch {
            _state.value = ScheduleState.Loading

            try {
                val schedule = getScheduleUseCase(filmId)
                _state.value = ScheduleState.Content(schedule)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = ScheduleState.Failure(ex.message)
            }
        }
    }

    fun goBack() {
        router.goBack()
    }

    fun openSeatSelection() {
        val selectedData = _uiState.value.selectedData
        if (selectedData != null) {
            router.openSeatSelection(filmId)
        }
    }
}