package com.ploddasha.cinemashiftapp.common.data.converter

import com.ploddasha.cinemashiftapp.common.data.model.film.UserRatingsItemModel
import com.ploddasha.cinemashiftapp.common.domain.entity.film.UserRatingsItem

class UserRatingsConverter {
    fun convertUserRatings(model: UserRatingsItemModel): UserRatingsItem =
        UserRatingsItem(
            kinopoisk = model.kinopoisk,
            imdb = model.imdb
        )
}