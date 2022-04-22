package com.ereldev.whattosee.android.category

import com.ereldev.whattosee.shared.category.CategoryRepository
import com.ereldev.whattosee.shared.category.CategoryToCategoryUIMapper
import com.ereldev.whattosee.shared.category.GetCategoriesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoryModule = module {

    viewModel { CategoriesViewModel(get()) }

    single { GetCategoriesUseCase(get()) }

    single { CategoryRepository(get(), get()) }

    single { CategoryToCategoryUIMapper() }

}