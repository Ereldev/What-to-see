package com.ereldev.whattosee.shared.show.modelui

data class ShowUI(
    val title: String,
    val date: String,
    val synopsis: String,
    val backgroundUrl: String? = null,
    val imageUrl: String? = null
)