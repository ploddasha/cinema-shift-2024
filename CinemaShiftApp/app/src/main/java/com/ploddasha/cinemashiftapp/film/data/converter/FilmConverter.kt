package com.ploddasha.cinemashiftapp.film.data.converter

import com.ploddasha.cinemashiftapp.film.data.model.ActorItemModel
import com.ploddasha.cinemashiftapp.film.data.model.CountryItemModel
import com.ploddasha.cinemashiftapp.film.data.model.DirectorItemModel
import com.ploddasha.cinemashiftapp.film.data.model.FilmDetailsModel
import com.ploddasha.cinemashiftapp.film.data.model.UserRatingsItemModel
import com.ploddasha.cinemashiftapp.film.domain.entity.ActorItem
import com.ploddasha.cinemashiftapp.film.domain.entity.CountryItem
import com.ploddasha.cinemashiftapp.film.domain.entity.DirectorItem
import com.ploddasha.cinemashiftapp.film.domain.entity.Film
import com.ploddasha.cinemashiftapp.film.domain.entity.UserRatingsItem

class FilmConverter {

    fun convert(model: FilmDetailsModel): Film =
        Film(
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