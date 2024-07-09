package com.ploddasha.cinemashiftapp.confirmation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.SelectedData

@Composable
fun ContentComponent(
    selectedData: SelectedData,
    onContinueBooking: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.confirmation_title),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 32.dp),
            )
        Text(
            text = stringResource(R.string.date_and_time),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "${selectedData.seance.date} ${selectedData.seance.time}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = stringResource(R.string.seats),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = selectedData.seats.joinToString { "${it.first} ряд - ${it.second}" },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Button(
            onClick = { onContinueBooking() },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.continue_button))
        }
    }

}