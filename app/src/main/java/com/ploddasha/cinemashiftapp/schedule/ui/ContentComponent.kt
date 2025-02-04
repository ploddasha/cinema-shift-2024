package com.ploddasha.cinemashiftapp.schedule.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem


@Composable
fun ContentComponent(
    schedules: List<ScheduleItem>,
    onDateAndTimeSelected: (String, String) -> Unit,
    onContinue: () -> Unit
) {
    var selectedTime by remember { mutableStateOf<String?>(null) }
    var selectedDate by remember { mutableStateOf(schedules.first().date) }

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ){
        SegmentedButton(
            dates = schedules.map { it.date },
            onDateSelected = { date -> selectedDate = date }
        )
        val selectedSchedule = schedules.find { it.date == selectedDate }
        selectedSchedule?.let {
            SelectedTimeContentComponent(
                schedule = it,
                onTimeSelected = { time -> selectedTime = time }
            )
        }
        if (selectedTime != null) {
            Button(
                onClick = {
                    onDateAndTimeSelected(selectedDate, selectedTime!!)
                    onContinue()
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.continue_button))
            }
        }
    }

}



