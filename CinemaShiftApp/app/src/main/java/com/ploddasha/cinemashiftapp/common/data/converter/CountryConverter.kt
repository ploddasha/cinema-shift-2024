package com.ploddasha.cinemashiftapp.common.data.converter

import com.ploddasha.cinemashiftapp.common.data.model.film.CountryItemModel
import com.ploddasha.cinemashiftapp.common.domain.entity.film.CountryItem

class CountryConverter {
    fun convertCountry(model: CountryItemModel): CountryItem =
        CountryItem(
            name = model.name,
            code = model.code,
            code2 = model.code2,
            id = model.id
        )
}