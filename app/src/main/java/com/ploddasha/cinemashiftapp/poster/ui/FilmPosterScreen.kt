package com.ploddasha.cinemashiftapp.poster.ui

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
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterState
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterViewModel

@Composable
fun FilmPosterScreen(
    filmPosterViewModel: FilmPosterViewModel
) {
    val filmPosterState by filmPosterViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        filmPosterViewModel.loadFilms()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.film_poster_title),
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = filmPosterState) {
            is FilmPosterState.Initial,
            is FilmPosterState.Loading -> LoadingComponent()

            is FilmPosterState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = { filmPosterViewModel.loadFilms() },
            )

            is FilmPosterState.Content -> ContentComponent(
                films = state.films,
                onItemClicked = filmPosterViewModel::openRouter
            )
        }
    }
}
