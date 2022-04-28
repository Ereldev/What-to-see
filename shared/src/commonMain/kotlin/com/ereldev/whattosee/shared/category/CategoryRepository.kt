package com.ereldev.whattosee.shared.category

import com.ereldev.whattosee.db.Category
import com.ereldev.whattosee.db.WHat2SeeDatabase
import com.ereldev.whattosee.shared.category.mapper.CategoryToCategoryUIMapper
import com.ereldev.whattosee.shared.category.mapper.KeywordToToCategoryKeywordUIMapper
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.CategoryUI
import kotlinx.coroutines.coroutineScope

class CategoryRepository(
    private val database: WHat2SeeDatabase,
    private val keywordService: KeywordService,
    private val categoryToCategoryUIMapper: CategoryToCategoryUIMapper,
    private val keywordToToCategoryKeywordUIMapper: KeywordToToCategoryKeywordUIMapper
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

    suspend fun searchKeywords(search: String): List<CategoryKeywordUI> =
        keywordService.search(search)
            .results
            .map { keywordToToCategoryKeywordUIMapper.from(it) }

}