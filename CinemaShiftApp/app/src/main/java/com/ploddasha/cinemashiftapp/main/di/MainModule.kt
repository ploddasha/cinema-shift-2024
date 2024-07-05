package com.ploddasha.cinemashiftapp.main.di

import com.ploddasha.cinemashiftapp.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    viewModelOf(::MainViewModel)
}