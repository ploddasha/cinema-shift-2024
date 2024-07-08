package com.ploddasha.cinemashiftapp.common.presentation

import kotlinx.serialization.Serializable

@Serializable
data class SelectedData(
    val filmId: String = "",
    val seats: List<Pair<Int, Int>> = emptyList(),
    val person: Person = Person(),
    val debitCard: DebitCard = DebitCard(),
    val seance: Seance = Seance(),
    val tickets: List<Ticket> = emptyList()
)

@Serializable
data class Person(
    val firstname: String = "",
    val lastname: String = "",
    val middlename: String = "",
    val phone: String = ""
)

@Serializable
data class DebitCard(
    val pan: String = "",
    val expireDate: String = "",
    val cvv: String = ""
)

@Serializable
data class Seance(
    val date: String = "",
    val time: String = ""
)

@Serializable
data class Ticket(
    val row: Int = 0,
    val column: Int = 0
)