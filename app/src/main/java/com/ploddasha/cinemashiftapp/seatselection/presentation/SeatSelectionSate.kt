package com.ploddasha.cinemashiftapp.seatselection.presentation

import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.SelectedData


interface SeatSelectionState {
    data object Initial : SeatSelectionState
    data object Loading : SeatSelectionState
    data class Failure(val message: String?) : SeatSelectionState
    data class Content(val selectedData: SelectedData) : SeatSelectionState
}