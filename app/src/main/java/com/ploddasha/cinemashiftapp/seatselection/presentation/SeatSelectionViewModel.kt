package com.ploddasha.cinemashiftapp.seatselection.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ploddasha.cinemashiftapp.common.presentation.SelectedData
import com.ploddasha.cinemashiftapp.schedule.domain.entity.PlaceItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class SeatSelectionViewModel(
    private val filmId: String,
    private val router: SeatSelectionRouter
): ViewModel() {

    // TODO replace this fake data with good data from previous screen
    private val _places = MutableStateFlow(
        listOf(
            listOf(PlaceItem(10, "Regular"), PlaceItem(12, "VIP")),
            listOf(PlaceItem(10, "Regular")),
            listOf(PlaceItem(10, "Regular"), PlaceItem(12, "VIP"))
        )
    )
    val places: StateFlow<List<List<PlaceItem>>> = _places

    private val _selectedRows = MutableStateFlow(listOf(0))
    val selectedRows: StateFlow<List<Int>> = _selectedRows

    private val _selectedSeats = MutableStateFlow(listOf(0))
    val selectedSeats: StateFlow<List<Int>> = _selectedSeats

    fun addTicket() {
        _selectedRows.update { it + 0 }
        _selectedSeats.update { it + 0 }
    }

    fun selectRow(index: Int, row: Int) {
        _selectedRows.update { rows ->
            rows.toMutableList().also { it[index] = row }
        }
    }

    fun selectSeat(index: Int, seat: Int) {
        _selectedSeats.update { seats ->
            seats.toMutableList().also { it[index] = seat }
        }
    }

    fun removeTicket(index: Int) {
        _selectedRows.update { rows ->
            rows.toMutableList().apply { removeAt(index) }
        }
        _selectedSeats.update { seats ->
            seats.toMutableList().apply { removeAt(index) }
        }
    }

    fun continueBooking() {
        router.openConfirmation(filmId)
    }


}