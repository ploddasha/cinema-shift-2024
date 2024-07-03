package com.ploddasha.cinemashiftapp.poster.data.converter

import com.ploddasha.cinemashiftapp.poster.data.model.ActorItemModel
import com.ploddasha.cinemashiftapp.poster.data.model.CountryItemModel
import com.ploddasha.cinemashiftapp.poster.data.model.DirectorItemModel
import com.ploddasha.cinemashiftapp.poster.data.model.FilmItemModel
import com.ploddasha.cinemashiftapp.poster.data.model.UserRatingsItemModel
import com.ploddasha.cinemashiftapp.poster.domain.entity.ActorItem
import com.ploddasha.cinemashiftapp.poster.domain.entity.CountryItem
import com.ploddasha.cinemashiftapp.poster.domain.entity.DirectorItem
import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem
import com.ploddasha.cinemashiftapp.poster.domain.entity.UserRatingsItem

class FilmItemConverter {

    fun convert(model: FilmItemModel): FilmItem =
        FilmItem(
            id = model.id,
            name = model.name,
            originalName = model.originalName,
            description = model.description,
            releaseDate = model.releaseDate,
            actorItems = model.actors.map { convertActor(it) },
            directorItems = model.directors.map { convertDirector(it) },
            runtime = model.runtime,
            ageRating = model.ageRating,
            genres = model.genres,
            userRatingsItem = convertUserRatings(model.userRatings),
            img = model.img,
            countryItem = convertCountry(model.country)
        )

    private fun convertActor(model: ActorItemModel): ActorItem =
        ActorItem(
            id = model.id,
            professions = model.professions,
            fullName = model.fullName
        )

    private fun convertDirector(model: DirectorItemModel): DirectorItem =
        DirectorItem(
            id = model.id,
            professions = model.professions,
            fullName = model.fullName
        )

    private fun convertUserRatings(model: UserRatingsItemModel): UserRatingsItem =
        UserRatingsItem(
            kinopoisk = model.kinopoisk,
            imdb = model.imdb
        )

    private fun convertCountry(model: CountryItemModel): CountryItem =
        CountryItem(
            name = model.name,
            code = model.code,
            code2 = model.code2,
            id = model.id
        )
}