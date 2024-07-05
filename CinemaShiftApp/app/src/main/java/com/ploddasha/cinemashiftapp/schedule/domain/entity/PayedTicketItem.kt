package com.ploddasha.cinemashiftapp.schedule.domain.entity

data class PayedTicketItem(
    val filmId: String,
    val row: Int,
    val column: Int,
    val seance: SeanceInfoItem,
    val phone: String
)