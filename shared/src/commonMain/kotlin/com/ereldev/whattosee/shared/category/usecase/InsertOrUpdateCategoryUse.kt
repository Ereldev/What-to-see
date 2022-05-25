package com.ereldev.whattosee.shared.category.usecase

import com.ereldev.whattosee.shared.category.CategoryRepository
import com.ereldev.whattosee.shared.category.model.CategoryUI

class InsertOrUpdateCategoryUse(
    private val categoryRepository: CategoryRepository
) {

    suspend fun execute(categoryUI: CategoryUI) =
        categoryRepository.insertOrUpdate(categoryUI)

}