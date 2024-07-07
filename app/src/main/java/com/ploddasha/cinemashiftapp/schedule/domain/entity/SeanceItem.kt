package com.ploddasha.cinemashiftapp.schedule.domain.entity

data class SeanceItem(
    val time: String,
    val hall: HallItem,
    val payedTickets: List<PayedTicketItem>
)