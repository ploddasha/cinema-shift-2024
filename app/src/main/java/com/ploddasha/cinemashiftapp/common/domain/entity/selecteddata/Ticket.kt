package com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val row: Int = 0,
    val column: Int = 0
)