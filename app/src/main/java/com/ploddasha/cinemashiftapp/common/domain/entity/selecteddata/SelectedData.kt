package com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata

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

