package com.ploddasha.cinemashiftapp.confirmation.presentation

import androidx.lifecycle.ViewModel
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionRouter

class ConfirmationViewModel(
    private val filmId: String,
    private val router: ConfirmationRouter
): ViewModel()  {

    fun openPersonInput() {
        router.openPersonInput(filmId)
    }

}