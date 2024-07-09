package com.ploddasha.cinemashiftapp.confirmation.di


import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val confirmationModule = module {

    viewModel {(filmId: String) ->
        ConfirmationViewModel(filmId, get())
    }
}