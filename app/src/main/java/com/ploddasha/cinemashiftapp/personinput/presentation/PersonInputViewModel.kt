package com.ploddasha.cinemashiftapp.personinput.presentation

import androidx.lifecycle.ViewModel
import com.ploddasha.cinemashiftapp.common.domain.entity.selecteddata.Person
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PersonInputViewModel(
    private val filmId: String,
    private val router: SeatSelectionRouter
): ViewModel()  {

    private val _uiState = MutableStateFlow(PersonInputUiState())
    val uiState: StateFlow<PersonInputUiState> = _uiState.asStateFlow()

    fun updateFirstname(firstname: String) {
        val isValid = validateName(firstname)
        _uiState.update { it.copy(firstname = firstname, isFirstnameValid = isValid) }
    }

    fun updateLastname(lastname: String) {
        val isValid = validateLastname(lastname)
        _uiState.update { it.copy(lastname = lastname, isLastnameValid = isValid) }
    }

    fun updateFatherName(fatherName: String) {
        _uiState.update { it.copy(fatherName = fatherName, isFatherNameValid = validateFatherName(fatherName)) }
    }

    fun updatePhone(phone: String) {
        val isPhoneValid = phone.matches(Regex("^\\d{10,15}$"))
        _uiState.update { it.copy(phone = phone, isPhoneValid = isPhoneValid) }
    }

    fun savePersonData() {
        val state = _uiState.value
        if (state.isFirstnameValid && state.isLastnameValid && state.isPhoneValid) {
            val person = Person(
                firstname = state.firstname,
                lastname = state.lastname,
                middlename = state.fatherName,
                phone = state.phone
            )
        }
    }

    private fun validateLastname(lastname: String): Boolean {
        val regex = Regex("^[a-zA-Zа-яА-Я][a-zA-Zа-яА-Я'\\-\\s]{0,58}[a-zA-Zа-яА-Я]$")
        return lastname.matches(regex)
    }

    private fun validateName(name: String): Boolean {
        val regex = Regex("^[a-zA-Zа-яА-Я][a-zA-Zа-яА-Я'\\-\\s]*(?<!['\\-\\s])$")
        return regex.matches(name) && !name.contains(Regex("['\\-\\s`]{2,}"))
    }

    private fun validateFatherName(fatherName: String): Boolean {
        return fatherName.length <= 60
    }

}