package com.ploddasha.cinemashiftapp.schedule.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem


@Composable
fun ContentComponent(
    schedules: List<ScheduleItem>
) {
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
        SelectedDateContentComponent(schedule = selectedSchedule)
    }

}



