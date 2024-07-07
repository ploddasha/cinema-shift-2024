package com.ploddasha.cinemashiftapp.film.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ploddasha.cinemashiftapp.R

@Composable
fun FilmImageCard(image: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data("https://shift-backend.onrender.com" + image)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.film_image),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(),
    )
}