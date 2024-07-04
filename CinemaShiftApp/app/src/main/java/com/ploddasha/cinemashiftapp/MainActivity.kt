package com.ploddasha.cinemashiftapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ploddasha.cinemashiftapp.poster.data.converter.FilmItemConverter
import com.ploddasha.cinemashiftapp.poster.data.network.FilmPosterApi
import com.ploddasha.cinemashiftapp.poster.data.repository.FilmPosterRepositoryImpl
import com.ploddasha.cinemashiftapp.poster.domain.GetFilmPosterUseCase
import com.ploddasha.cinemashiftapp.poster.domain.repository.FilmPosterRepository
import com.ploddasha.cinemashiftapp.poster.ui.FilmPosterScreen
import com.ploddasha.cinemashiftapp.ui.theme.CinemaShiftAppTheme

class MainActivity : ComponentActivity() {
    private val networkModule = NetworkModule()

    private val filmPosterApi = networkModule.retrofit.create(FilmPosterApi::class.java)
    private val filmItemConverter = FilmItemConverter()
    private val filmPosterRepository: FilmPosterRepository = FilmPosterRepositoryImpl(filmPosterApi, filmItemConverter)
    private val getFilmPosterUseCase = GetFilmPosterUseCase(filmPosterRepository)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaShiftAppTheme {
                MainScreen(
                    getFilmPosterUseCase = getFilmPosterUseCase
                )
            }
        }
    }
}
