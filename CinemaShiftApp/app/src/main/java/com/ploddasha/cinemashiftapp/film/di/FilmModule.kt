package com.ploddasha.cinemashiftapp.film.di

import com.ploddasha.cinemashiftapp.film.data.network.FilmApi
import com.ploddasha.cinemashiftapp.film.domain.repository.FilmRepository
import com.ploddasha.cinemashiftapp.film.presentation.FilmViewModel
import com.ploddasha.cinemashiftapp.film.domain.usecase.GetFilmUseCase
import com.ploddasha.cinemashiftapp.film.data.converter.FilmConverter
import com.ploddasha.cinemashiftapp.film.data.repository.FilmRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val filmViewModel = module {
    single { get<Retrofit>().create(FilmApi::class.java) }
    singleOf(::FilmConverter)
    singleOf(::FilmRepositoryImpl) bind FilmRepository::class

    factoryOf(::GetFilmUseCase)

    viewModel {(filmId: String) ->
        FilmViewModel(filmId, get(), get())
    }
}