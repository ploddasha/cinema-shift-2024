package com.ploddasha.cinemashiftapp.film.domain.entity

data class Film(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actorItems: List<ActorItem>,
    val directorItems: List<DirectorItem>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatingsItem: UserRatingsItem,
    val img: String,
    val countryItem: CountryItem
)