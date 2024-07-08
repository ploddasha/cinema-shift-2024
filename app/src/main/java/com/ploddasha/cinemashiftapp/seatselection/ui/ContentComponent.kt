package com.ploddasha.cinemashiftapp.seatselection.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.schedule.domain.entity.PlaceItem

@Composable
fun ContentComponent(
    seats: List<List<PlaceItem>>,
    selectedRow: Int,
    selectedSeat: Int,
    onRowSelected: (Int) -> Unit,
    onSeatSelected: (Int) -> Unit
) {
    val rows = getRowIndices(seats)

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ){
        Text(
            text = stringResource(R.string.row),
            style = MaterialTheme.typography.titleMedium,
        )
        ChooseRowComponent(
            rows = rows,
            selectedRow = selectedRow,
            onRowSelected = onRowSelected
        )

        Text(
            text = stringResource(R.string.seat),
            style = MaterialTheme.typography.titleMedium
        )

        ChooseSeatComponent(
            seats = seats[selectedRow],
            selectedColumn = selectedSeat,
            onSeatSelected = onSeatSelected
        )
    }

}

fun getRowIndices(places: List<List<PlaceItem>>): List<Int> {
    return places.indices.map { it + 1 }
}



