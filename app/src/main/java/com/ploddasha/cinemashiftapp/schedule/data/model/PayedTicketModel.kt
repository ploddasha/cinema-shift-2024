package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PayedTicketModel(
    val filmId: String,
    val row: Int,
    val column: Int,
    val seance: SeanceInfoModel,
    val phone: String
)