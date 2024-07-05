package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SeanceModel(
    val time: String,
    val hall: HallModel,
    val payedTickets: List<PayedTicketModel>
)

