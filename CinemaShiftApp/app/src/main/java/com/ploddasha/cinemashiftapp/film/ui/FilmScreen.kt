package com.ploddasha.cinemashiftapp.film.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.film.presentation.FilmState
import com.ploddasha.cinemashiftapp.film.presentation.FilmViewModel

@Composable
fun FilmScreen(
    filmViewModel: FilmViewModel
) {
    val filmState by filmViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        filmViewModel.loadFilm()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.film_poster_title),
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = filmState) {
            is FilmState.Initial,
            is FilmState.Loading -> LoadingComponent()

            is FilmState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = { filmViewModel.loadFilm() },
            )

            is FilmState.Content -> {
                if (state.film != null) {
                    ContentComponent(
                        film = state.film,
                        onItemClicked = filmViewModel::openSchedule
                    )
                } else {
                    ErrorComponent(
                        message = stringResource(id = R.string.error_film_not_found),
                        onRetry = { filmViewModel.loadFilm() },
                    )
                }
            }
        }
    }
}
