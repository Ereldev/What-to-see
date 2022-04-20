package com.ereldev.whattosee.shared.show.model

data class ShowsUI(
    val movies: List<ShowUI>,
    val tvShows: List<ShowUI>
)

data class ShowUI(
    val title: String,
    val date: String,
    val overview: String,
    val backgroundUrl: String? = null,
    val imageUrl: String? = null
)