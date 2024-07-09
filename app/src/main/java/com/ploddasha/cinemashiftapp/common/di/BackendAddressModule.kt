package com.ploddasha.cinemashiftapp.common.di

import org.koin.dsl.module

val backendAddressModule = module {
    single { "https://shift-backend.onrender.com" }
}