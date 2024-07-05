package com.ploddasha.cinemashiftapp.film.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.film.domain.entity.Film


@Composable
fun ContentComponent(
    film: Film
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        item {
            FilmImageCard(image = film.img)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${film.name} (${film.ageRating})",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${film.releaseDate}, ${film.countryItem.name}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Kinopoisk ${film.userRatingsItem.kinopoisk}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "IMDB ${film.userRatingsItem.imdb}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = film.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = stringResource(R.string.see_schedule))
            }
        }
    }
}
