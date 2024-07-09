package com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val firstname: String = "",
    val lastname: String = "",
    val middlename: String = "",
    val phone: String = ""
)