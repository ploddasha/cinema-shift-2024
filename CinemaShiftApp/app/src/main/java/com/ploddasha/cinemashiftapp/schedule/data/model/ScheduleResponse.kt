package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleResponse(
    val success: Boolean,
    val reason: String? = null,
    val schedules: List<ScheduleModel>
)