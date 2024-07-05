package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SeanceModel(
    val time: String,
    val hallModel: HallModel,
    val payedTicketModels: List<PayedTicketModel>
)

