package com.ploddasha.cinemashiftapp.common.data.converter

import com.ploddasha.cinemashiftapp.common.data.model.film.ActorItemModel
import com.ploddasha.cinemashiftapp.common.domain.entity.film.ActorItem

class ActorConverter {
    fun convertActor(model: ActorItemModel): ActorItem =
        ActorItem(
            id = model.id,
            professions = model.professions,
            fullName = model.fullName
        )
}