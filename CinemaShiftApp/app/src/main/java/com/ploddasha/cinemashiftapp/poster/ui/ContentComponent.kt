package com.ploddasha.cinemashiftapp.poster.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem

@Composable
fun ContentComponent(
    films: List<FilmItem>,
    onItemClicked: (filmId: String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(films) { film ->
            FilmItemView(
                film,
                onItemClicked = { onItemClicked(film.id) }
            )
        }
    }
}

@Composable
private fun FilmItemView(
    item: FilmItem,
    onItemClicked: () -> Unit
) {
    Column (
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        //Image
        FilmImageCard(image = item.img)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${item.name} (${item.ageRating})",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${item.releaseDate}, ${item.countryItem.name}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onItemClicked() },
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(text = stringResource(R.string.more_details))
        }

    }
}
