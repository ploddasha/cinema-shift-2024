package com.ploddasha.cinemashiftapp.poster.data.converter

import com.ploddasha.cinemashiftapp.common.data.converter.ActorConverter
import com.ploddasha.cinemashiftapp.common.data.converter.CountryConverter
import com.ploddasha.cinemashiftapp.common.data.converter.DirectorConverter
import com.ploddasha.cinemashiftapp.common.data.converter.UserRatingsConverter
import com.ploddasha.cinemashiftapp.poster.data.model.FilmItemModel
import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem

class FilmItemConverter {

    private val actorConverter = ActorConverter()
    private val directorConverter = DirectorConverter()
    private val userRatingsConverter = UserRatingsConverter()
    private val countryConverter = CountryConverter()

    fun convert(model: FilmItemModel): FilmItem =
        FilmItem(
            id = model.id,
            name = model.name,
            originalName = model.originalName,
            description = model.description,
            releaseDate = model.releaseDate,
            actorItems = model.actors.map { actorConverter.convertActor(it) },
            directorItems = model.directors.map { directorConverter.convertDirector(it) },
            runtime = model.runtime,
            ageRating = model.ageRating,
            genres = model.genres,
            userRatingsItem = userRatingsConverter.convertUserRatings(model.userRatings),
            img = model.img,
            countryItem = countryConverter.convertCountry(model.country)
        )

}