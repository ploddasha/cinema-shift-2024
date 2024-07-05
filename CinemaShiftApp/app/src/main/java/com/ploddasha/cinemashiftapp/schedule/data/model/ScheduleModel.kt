package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleModel(
    val date: String,
    val seanceModels: List<SeanceModel>
)