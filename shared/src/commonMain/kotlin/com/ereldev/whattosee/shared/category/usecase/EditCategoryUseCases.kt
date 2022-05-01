package com.ereldev.whattosee.shared.category.usecase

import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.CategoryUI

class EditCategoryUseCases {

    fun changeName(categoryUI: CategoryUI, name:String): CategoryUI =
        categoryUI.copy(name = name)

    fun removeKeyword(categoryUI: CategoryUI, keyword: CategoryKeywordUI): CategoryUI {
        val newKeywords = categoryUI.keywords.filter { it.id != keyword.id }

        return categoryUI.copy(keywords = newKeywords)
    }

    fun addKeyword(categoryUI: CategoryUI, keyword: CategoryKeywordUI): CategoryUI {
        if (categoryUI.keywords.contains(keyword)) return categoryUI

        val newKeywords = categoryUI.keywords + keyword

        return categoryUI.copy(keywords = newKeywords)
    }

}