package com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata

import kotlinx.serialization.Serializable

@Serializable
data class DebitCard(
    val pan: String = "",
    val expireDate: String = "",
    val cvv: String = ""
)