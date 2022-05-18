package com.ereldev.whattosee.android.category.edit

import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI

sealed class CategoryKeywordsState {
    object Loading: CategoryKeywordsState()
    data class Error(val throwable: Throwable): CategoryKeywordsState()
    data class Success(val keywordsUI: List<CategoryKeywordUI>): CategoryKeywordsState()
}