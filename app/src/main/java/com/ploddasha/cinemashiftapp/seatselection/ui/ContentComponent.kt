package com.ploddasha.cinemashiftapp.seatselection.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.schedule.domain.entity.PlaceItem

@Composable
fun ContentComponent(
    seats: List<List<PlaceItem>>,
    selectedRows: List<Int>,
    selectedSeats: List<Int>,
    onRowSelected: (Int, Int) -> Unit,
    onSeatSelected: (Int, Int) -> Unit,
    onAddTicket: () -> Unit,
    onRemoveTicket: (Int) -> Unit,
    onContinueBooking: () -> Unit
) {

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ){
        selectedRows.forEachIndexed { index, selectedRow ->
            val rows = getRowIndices(seats)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(
                        id = R.string.ticket_info,
                        selectedRow + 1,
                        selectedSeats[index] + 1
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                if (selectedRows.size > 1) {
                    IconButton(onClick = { onRemoveTicket(index) }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = stringResource(R.string.delete_ticket))
                    }
                }
            }
            Text(
                text = stringResource(R.string.row),
                style = MaterialTheme.typography.titleMedium,
            )
            ChooseRowComponent(
                rows = rows,
                selectedRow = selectedRow,
                onRowSelected = { onRowSelected(index, it) }
            )

            Text(
                text = stringResource(R.string.seat),
                style = MaterialTheme.typography.titleMedium
            )

            ChooseSeatComponent(
                seats = seats[selectedRow],
                selectedColumn = selectedSeats[index],
                onSeatSelected = { onSeatSelected(index, it) }
            )
        }
        OutlinedButton(
            onClick = { onAddTicket() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.add_ticket))
        }
        Button(
            onClick = { onContinueBooking() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.continue_button))
        }
    }

}

fun getRowIndices(places: List<List<PlaceItem>>): List<Int> {
    return places.indices.map { it + 1 }
}



