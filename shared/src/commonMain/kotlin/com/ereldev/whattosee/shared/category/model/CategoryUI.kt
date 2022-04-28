package com.ereldev.whattosee.shared.category.model

data class CategoryUI(
    val name: String,
    val keywords: List<CategoryKeywordUI>
)

data class CategoryKeywordUI(
    val id: Int,
    val name: String
)