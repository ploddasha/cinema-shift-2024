package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SeanceInfoModel(
    val date: String,
    val time: String
)