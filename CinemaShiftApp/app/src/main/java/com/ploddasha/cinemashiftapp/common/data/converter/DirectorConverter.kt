package com.ploddasha.cinemashiftapp.common.data.converter

import com.ploddasha.cinemashiftapp.common.data.model.film.DirectorItemModel
import com.ploddasha.cinemashiftapp.common.domain.entity.film.DirectorItem

class DirectorConverter {
    fun convertDirector(model: DirectorItemModel): DirectorItem =
        DirectorItem(
            id = model.id,
            professions = model.professions,
            fullName = model.fullName
        )
}