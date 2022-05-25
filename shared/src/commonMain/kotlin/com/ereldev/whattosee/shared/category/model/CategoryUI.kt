package com.ereldev.whattosee.shared.category.model

data class CategoryUI(
    val id: Long?,
    val name: String,
    var keywords: List<CategoryKeywordUI>
)

data class CategoryKeywordUI(
    val id: Int,
    val name: String
)