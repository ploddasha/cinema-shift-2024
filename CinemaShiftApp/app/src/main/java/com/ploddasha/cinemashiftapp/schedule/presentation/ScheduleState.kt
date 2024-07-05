package com.ploddasha.cinemashiftapp.schedule.presentation

import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem

interface ScheduleState {
    data object Initial : ScheduleState
    data object Loading : ScheduleState
    data class Failure(val message: String?) : ScheduleState
    data class Content(val schedule: List<ScheduleItem>) : ScheduleState
}