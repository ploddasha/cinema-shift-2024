package com.ploddasha.cinemashiftapp.poster.di

import com.ploddasha.cinemashiftapp.poster.domain.GetFilmPosterUseCase
import com.ploddasha.cinemashiftapp.poster.data.network.FilmPosterApi
import com.ploddasha.cinemashiftapp.poster.data.converter.FilmItemConverter
import com.ploddasha.cinemashiftapp.poster.domain.repository.FilmPosterRepository
import com.ploddasha.cinemashiftapp.poster.data.repository.FilmPosterRepositoryImpl
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val filmPosterModule = module {
    single { get<Retrofit>().create(FilmPosterApi::class.java) }
    singleOf(::FilmItemConverter)
    singleOf(::FilmPosterRepositoryImpl) bind FilmPosterRepository::class

    factoryOf(::GetFilmPosterUseCase)

    viewModelOf(::FilmPosterViewModel)
}