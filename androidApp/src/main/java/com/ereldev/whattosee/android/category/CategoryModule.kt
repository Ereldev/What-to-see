package com.ereldev.whattosee.android.category

import com.ereldev.whattosee.android.category.edit.CategoryEditViewModel
import com.ereldev.whattosee.android.category.list.CategoriesViewModel
import com.ereldev.whattosee.shared.category.CategoryRepository
import com.ereldev.whattosee.shared.category.KeywordService
import com.ereldev.whattosee.shared.category.mapper.CategoryToCategoryUIMapper
import com.ereldev.whattosee.shared.category.mapper.KeywordToToCategoryKeywordUIMapper
import com.ereldev.whattosee.shared.category.model.CategoryUI
import com.ereldev.whattosee.shared.category.usecase.EditCategoryUseCases
import com.ereldev.whattosee.shared.category.usecase.GetCategoriesUseCase
import com.ereldev.whattosee.shared.category.usecase.InsertOrUpdateCategoryUse
import com.ereldev.whattosee.shared.category.usecase.SearchCategoryKeywordsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoryModule = module {

    viewModel { CategoriesViewModel(get()) }
    viewModel { (categoryUI: CategoryUI?, onCategorySaved: () -> Unit) ->
        CategoryEditViewModel(categoryUI, onCategorySaved, get(), get(), get())
    }

    single { GetCategoriesUseCase(get()) }
    single { EditCategoryUseCases() }
    single { SearchCategoryKeywordsUseCase(get()) }
    single { InsertOrUpdateCategoryUse(get()) }

    single { CategoryRepository(get(), get(), get(), get()) }

    single { KeywordService() }

    single { CategoryToCategoryUIMapper() }
    single { KeywordToToCategoryKeywordUIMapper() }

}