package com.ploddasha.cinemashiftapp.film.data.model

import com.ploddasha.cinemashiftapp.common.data.model.film.ActorItemModel
import com.ploddasha.cinemashiftapp.common.data.model.film.CountryItemModel
import com.ploddasha.cinemashiftapp.common.data.model.film.DirectorItemModel
import com.ploddasha.cinemashiftapp.common.data.model.film.UserRatingsItemModel
import kotlinx.serialization.Serializable


@Serializable
data class FilmDetailsModel(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<ActorItemModel>,
    val directors: List<DirectorItemModel>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: UserRatingsItemModel,
    val img: String,
    val country: CountryItemModel
)