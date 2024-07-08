package com.ploddasha.cinemashiftapp.seatselection.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionViewModel

@Composable
fun SeatSelectionScreen(
    seatSelectionViewModel: SeatSelectionViewModel
){
    val places by seatSelectionViewModel.places.collectAsState()
    val selectedRows by seatSelectionViewModel.selectedRows.collectAsState()
    val selectedSeats by seatSelectionViewModel.selectedSeats.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.seat_selection_title),
            style = MaterialTheme.typography.titleLarge,
        )

        ContentComponent(
            seats = places,
            selectedRows = selectedRows,
            selectedSeats = selectedSeats,
            onRowSelected = seatSelectionViewModel::selectRow,
            onSeatSelected = seatSelectionViewModel::selectSeat,
            onAddTicket = seatSelectionViewModel::addTicket,
            onRemoveTicket = seatSelectionViewModel::removeTicket,
            onContinueBooking = seatSelectionViewModel::continueBooking
        )
    }

}