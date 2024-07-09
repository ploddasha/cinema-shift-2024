package com.ploddasha.cinemashiftapp.personinput.di


import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val personInputModule = module {

    viewModel {(filmId: String) ->
        PersonInputViewModel(filmId, get())
    }
}