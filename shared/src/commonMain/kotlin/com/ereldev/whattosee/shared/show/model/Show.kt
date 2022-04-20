package com.ereldev.whattosee.shared.show.model

data class Show(
    val type: ShowType,
    val id: Int,
    val title: String,
    val overview: String,
    val originalDate: String,
    val date: String,
    val backgroundUrl: String? = null,
    val imageUrl: String? = null
)

enum class ShowType {
    MOVIE, TV
}