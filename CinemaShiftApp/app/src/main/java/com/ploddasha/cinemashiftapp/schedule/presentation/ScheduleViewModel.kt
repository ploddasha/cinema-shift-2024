package com.ploddasha.cinemashiftapp.schedule.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ploddasha.cinemashiftapp.schedule.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ScheduleViewModel(
    private val filmId: String,
    private val getScheduleUseCase: GetScheduleUseCase,
    private val router: ScheduleRouter,
) : ViewModel() {

    private val _state = MutableStateFlow<ScheduleState>(ScheduleState.Initial)
    val state: StateFlow<ScheduleState> = _state

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
}