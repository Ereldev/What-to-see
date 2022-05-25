package com.ereldev.whattosee.shared.category.factory

import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.CategoryUI

class CategoryFactory {

    companion object {

        fun getCategory() = CategoryUI(
            null,
            "Category name",
            listOf(
                CategoryKeywordUI(1, "Keyword name 1"),
                CategoryKeywordUI(2, "Keyword name 2"),
                CategoryKeywordUI(3, "Keyword name 3"),
                CategoryKeywordUI(4, "Keyword name 4"),
                CategoryKeywordUI(5, "Keyword name 5"),
            )
        )

    }

}