package com.ploddasha.cinemashiftapp.confirmation.presentation

import androidx.lifecycle.ViewModel
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.DebitCard
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.Person
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.Seance
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.SelectedData
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.Ticket

class ConfirmationViewModel(
    private val filmId: String,
    private val router: ConfirmationRouter
): ViewModel()  {

    val fakeSelectedData = SelectedData(
        filmId = "12345",
        seats = listOf(Pair(2, 8), Pair(2, 9)),
        person = Person(),
        debitCard = DebitCard(),
        seance = Seance(
            date = "3 июля 2023",
            time = "13:45"
        ),
        tickets = listOf(
            Ticket(row = 2, column = 8),
            Ticket(row = 2, column = 9)
        )
    )

    fun openPersonInput() {
        router.openPersonInput(filmId)
    }

}