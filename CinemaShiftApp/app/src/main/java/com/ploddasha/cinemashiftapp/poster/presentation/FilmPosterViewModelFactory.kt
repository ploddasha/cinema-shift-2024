package com.ploddasha.cinemashiftapp.poster.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ploddasha.cinemashiftapp.poster.domain.GetFilmPosterUseCase

class FilmPosterViewModelFactory(
    private val getFilmPosterUseCase: GetFilmPosterUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == FilmPosterViewModel::class.java) { "Unknown ViewModel: $modelClass" }
        return FilmPosterViewModel(getFilmPosterUseCase) as T
    }

}