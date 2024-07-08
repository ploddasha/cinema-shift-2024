package com.ploddasha.cinemashiftapp.seatselection.di


import com.ploddasha.cinemashiftapp.common.presentation.SelectedData
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val seatSelectionViewModule = module {

    viewModel {(filmId: String) ->
        SeatSelectionViewModel(filmId, get())
    }
}