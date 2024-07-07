package com.ploddasha.cinemashiftapp.schedule.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem

@Composable
fun SelectedDateContentComponent(schedule: ScheduleItem) {
    val groupedSeances = remember(schedule.seances) {
        schedule.seances.groupBy { it.hall.name }
    }

    Column {
        groupedSeances.forEach { (hallName, seances) ->
            Text(
                text = hallName,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(seances) { seance ->
                    Button(onClick = { /* TODO Handle click */ }) {
                        Text(text = seance.time)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}