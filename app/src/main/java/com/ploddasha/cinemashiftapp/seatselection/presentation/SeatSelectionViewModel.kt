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

    private val _places = MutableStateFlow(
        listOf(
            listOf(PlaceItem(10, "Regular"), PlaceItem(12, "VIP")),
            listOf(PlaceItem(10, "Regular")),
            listOf(PlaceItem(10, "Regular"), PlaceItem(12, "VIP"))
        )
    )
    val places: StateFlow<List<List<PlaceItem>>> = _places

    private val _selectedRow = MutableStateFlow(0)
    val selectedRow: StateFlow<Int> = _selectedRow

    private val _selectedSeat = MutableStateFlow(0)
    val selectedSeat: StateFlow<Int> = _selectedSeat

    fun selectRow(row: Int) {
        _selectedRow.update { row }
    }

    fun selectSeat(seat: Int) {
        _selectedSeat.update { seat }
    }




}