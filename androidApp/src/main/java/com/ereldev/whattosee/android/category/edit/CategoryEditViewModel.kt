package com.ereldev.whattosee.android.category.edit

import androidx.lifecycle.MutableLiveData
import com.ereldev.whattosee.android.common.AbstractViewModel
import com.ereldev.whattosee.shared.category.SearchCategoryKeywordsUseCase
import com.ereldev.whattosee.shared.category.model.CategoryUI

class CategoryEditViewModel(
    initialCategoryUI: CategoryUI?,
    private val searchCategoryKeywordsUseCase: SearchCategoryKeywordsUseCase
): AbstractViewModel() {

    val categoryUI: MutableLiveData<CategoryUI> by lazy {
        MutableLiveData<CategoryUI>()
    }

    val currentSearch: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    init {
        if (initialCategoryUI == null) {
            categoryUI.postValue(
                CategoryUI("", listOf())
            )
        } else {
            categoryUI.postValue(initialCategoryUI)
        }
    }

    fun onValidClick() {

    }

    fun onNameChange(name: String) {
        categoryUI.postValue(
            categoryUI.value?.copy(name = name)
        )
    }

    fun onSearchKeywordChange(search: String) {
        currentSearch.postValue(search)

        request({ searchCategoryKeywordsUseCase.execute(search) },
            {
                print(it)
            },
            {
                print(it)
            })
    }

}