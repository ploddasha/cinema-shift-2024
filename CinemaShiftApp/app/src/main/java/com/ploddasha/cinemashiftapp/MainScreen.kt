package com.ploddasha.cinemashiftapp

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ploddasha.cinemashiftapp.poster.domain.GetFilmPosterUseCase
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterRoute
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterViewModel
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterViewModelFactory
import com.ploddasha.cinemashiftapp.poster.ui.FilmPosterScreen

@Composable
fun MainScreen(
    getFilmPosterUseCase: GetFilmPosterUseCase,
) {
    val navController = rememberNavController()

    Surface {
        //NavHost(navController = navController, startDestination = FilmPosterRoute) {
        NavHost(navController = navController, startDestination = "FilmPoster") {
        //composable<FilmPosterRoute> {
        composable("FilmPoster") {
            val viewModel: FilmPosterViewModel = viewModel(factory = FilmPosterViewModelFactory(getFilmPosterUseCase))
                FilmPosterScreen(
                    viewModel
                )
            }
        }
    }
}