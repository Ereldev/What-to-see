package com.ereldev.whattosee.shared.category.model

data class CategoryUI(
    val name: String,
    val tags: List<CategoryTagUI>
)

data class CategoryTagUI(
    val id: String,
    val name: String
)