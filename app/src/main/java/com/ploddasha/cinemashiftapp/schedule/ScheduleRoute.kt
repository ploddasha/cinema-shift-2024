package com.ploddasha.cinemashiftapp.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleRoute(
    val filmId: String,
)