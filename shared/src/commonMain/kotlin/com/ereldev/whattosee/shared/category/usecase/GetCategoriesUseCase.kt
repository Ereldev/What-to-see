package com.ereldev.whattosee.shared.category.usecase

import com.ereldev.whattosee.shared.category.CategoryRepository
import com.ereldev.whattosee.shared.category.model.CategoryUI

class GetCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    suspend fun execute(): List<CategoryUI> =
        categoryRepository.getCategories()

}