package com.ereldev.whattosee.shared.category

import com.ereldev.whattosee.db.CategoryKeyword
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
            .map { category ->
                val keywords = database.categoryQueries
                    .selectKeywords(category.id)
                    .executeAsList()

                categoryToCategoryUIMapper.from(category).apply {
                    this.keywords = keywords.map { keyword ->
                        CategoryKeywordUI(keyword.id.toInt(), keyword.name)
                    }
                }
            }
    }

    suspend fun insertOrUpdate(categoryUI: CategoryUI) = coroutineScope {
        database.categoryQueries.transaction {
            database.categoryQueries
                .insertOrUpdate(categoryToCategoryUIMapper.to(categoryUI))

            val lastInsertRowId = database.categoryQueries.lastInsertRowId().executeAsOne()

            categoryUI.keywords.forEach {
                database.categoryQueries
                    .insertOrUpdateKeyword(
                        CategoryKeyword(
                            it.id.toLong(),
                            it.name,
                            categoryUI.id ?: lastInsertRowId
                        )
                    )
            }
        }
    }

    suspend fun searchKeywords(search: String): List<CategoryKeywordUI> =
        keywordService.search(search)
            .results
            .map { keywordToToCategoryKeywordUIMapper.from(it) }

}