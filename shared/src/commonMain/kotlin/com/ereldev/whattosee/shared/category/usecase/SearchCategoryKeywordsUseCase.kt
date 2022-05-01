package com.ereldev.whattosee.shared.category.usecase

import com.ereldev.whattosee.shared.category.CategoryRepository
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI

class SearchCategoryKeywordsUseCase(
    private val categoryRepository: CategoryRepository
) {

    suspend fun execute(search: String): List<CategoryKeywordUI> =
        categoryRepository.searchKeywords(search)

}