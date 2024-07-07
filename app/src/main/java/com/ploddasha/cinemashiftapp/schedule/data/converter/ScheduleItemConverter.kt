package com.ploddasha.cinemashiftapp.schedule.data.converter

import com.ploddasha.cinemashiftapp.schedule.data.model.*
import com.ploddasha.cinemashiftapp.schedule.domain.entity.*

class ScheduleItemConverter {

    fun convert(model: ScheduleModel): ScheduleItem =
        ScheduleItem(
            date = model.date,
            seances = model.seances.map { convertSeance(it) }
        )

    private fun convertSeance(model: SeanceModel): SeanceItem =
        SeanceItem(
            time = model.time,
            hall = convertHall(model.hall),
            payedTickets = model.payedTickets.map { convertPayedTicket(it) }
        )

    private fun convertHall(model: HallModel): HallItem =
        HallItem(
            name = model.name,
            places = model.places.map { row -> row.map { convertPlace(it) } }
        )

    private fun convertPlace(model: PlaceModel): PlaceItem =
        PlaceItem(
            price = model.price,
            type = model.type
        )

    private fun convertPayedTicket(model: PayedTicketModel): PayedTicketItem =
        PayedTicketItem(
            filmId = model.filmId,
            row = model.row,
            column = model.column,
            seance = convertSeanceInfo(model.seance),
            phone = model.phone
        )

    private fun convertSeanceInfo(model: SeanceInfoModel): SeanceInfoItem =
        SeanceInfoItem(
            date = model.date,
            time = model.time
        )
}