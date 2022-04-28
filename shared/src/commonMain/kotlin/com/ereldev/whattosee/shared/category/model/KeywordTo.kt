package com.ereldev.whattosee.shared.category.model

import kotlinx.serialization.Serializable

@Serializable
data class KeywordTo(
    val id: Int,
    val name: String
)