package com.ereldev.whattosee.shared.category

import com.ereldev.whattosee.db.Category
import com.ereldev.whattosee.db.WHat2SeeDatabase
import com.ereldev.whattosee.shared.category.model.CategoryUI
import kotlinx.coroutines.coroutineScope

class CategoryRepository(
    private val database: WHat2SeeDatabase,
    private val categoryToCategoryUIMapper: CategoryToCategoryUIMapper
) {

    suspend fun getCategories(): List<CategoryUI> = coroutineScope{
        database.categoryQueries
            .selectAll()
            .executeAsList()
            .map { categoryToCategoryUIMapper.from(it) }
    }

    suspend fun create(category: Category) = coroutineScope {
        database.categoryQueries
            .insert(category)
    }

}