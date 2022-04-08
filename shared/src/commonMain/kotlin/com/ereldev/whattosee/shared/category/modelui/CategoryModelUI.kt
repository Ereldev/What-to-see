package com.ereldev.whattosee.shared.category.modelui

data class CategoryModelUI(
    val name: String,
    val tags: List<CategoryTagUI>
)

data class CategoryTagUI(
    val id: String,
    val name: String
)