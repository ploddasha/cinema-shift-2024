package com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata

import kotlinx.serialization.Serializable

@Serializable
data class Seance(
    val date: String = "",
    val time: String = ""
)