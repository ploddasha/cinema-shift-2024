package com.ploddasha.cinemashiftapp.schedule.di

import com.ploddasha.cinemashiftapp.schedule.domain.usecase.GetScheduleUseCase
import com.ploddasha.cinemashiftapp.schedule.data.converter.ScheduleItemConverter
import com.ploddasha.cinemashiftapp.schedule.domain.repository.ScheduleRepository
import com.ploddasha.cinemashiftapp.schedule.data.repository.ScheduleRepositoryImpl
import com.ploddasha.cinemashiftapp.schedule.data.network.ScheduleApi
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val scheduleViewModel = module {
    single { get<Retrofit>().create(ScheduleApi::class.java) }
    singleOf(::ScheduleItemConverter)
    singleOf(::ScheduleRepositoryImpl) bind ScheduleRepository::class

    factoryOf(::GetScheduleUseCase)

    viewModel {(filmId: String) ->
        ScheduleViewModel(filmId, get(), get())
    }
}