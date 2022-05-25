package com.ereldev.whattosee.android.category.edit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ereldev.whattosee.android.common.AbstractViewModel
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.CategoryUI
import com.ereldev.whattosee.shared.category.usecase.EditCategoryUseCases
import com.ereldev.whattosee.shared.category.usecase.InsertOrUpdateCategoryUse
import com.ereldev.whattosee.shared.category.usecase.SearchCategoryKeywordsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CategoryEditViewModel(
    initialCategoryUI: CategoryUI?,
    private val onCategorySaved: () -> Unit,
    private val editCategoryUseCases: EditCategoryUseCases,
    private val searchCategoryKeywordsUseCase: SearchCategoryKeywordsUseCase,
    private val insertOrUpdateCategoryUse: InsertOrUpdateCategoryUse
): AbstractViewModel() {

    val categoryUI: MutableLiveData<CategoryUI> by lazy {
        MutableLiveData<CategoryUI>()
    }

    val currentSearch: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val keywordsUIState: MutableLiveData<CategoryKeywordsState> by lazy {
        MutableLiveData<CategoryKeywordsState>()
    }

    private var searchDebounceJob: Job? = null

    init {
        if (initialCategoryUI == null) {
            categoryUI.postValue(
                CategoryUI(null, "", listOf())
            )
        } else {
            categoryUI.postValue(initialCategoryUI)
        }
    }

    fun onValidClick() {
        categoryUI.value?.let {
            request({ insertOrUpdateCategoryUse.execute(it) },
                {
                    onCategorySaved()
                },
                {
                    Log.e("CategoryEditViewModel", it.toString())
                })
        }
    }

    fun onNameChange(name: String) {
        categoryUI.value?.let { category ->
            categoryUI.postValue(
                editCategoryUseCases.changeName(category, name)
            )
        }
    }

    fun onRemoveKeyword(keyword: CategoryKeywordUI) {
        categoryUI.value?.let { category ->
            categoryUI.postValue(
                editCategoryUseCases.removeKeyword(category, keyword)
            )
        }
    }

    fun onSearchKeywordChange(search: String) {
        currentSearch.postValue(search)

        searchDebounceJob?.cancel()
        searchDebounceJob = viewModelScope.launch {
            delay(500)

            keywordsUIState.postValue(CategoryKeywordsState.Loading)

            request({ searchCategoryKeywordsUseCase.execute(search) },
                {
                    keywordsUIState.postValue(CategoryKeywordsState.Success(it))
                },
                {
                    keywordsUIState.postValue(CategoryKeywordsState.Error(it))
                })
        }
    }

    fun onRetrySearch() {
        currentSearch.value?.let {
            onSearchKeywordChange(it)
        }
    }

    fun onAddKeyword(keyword: CategoryKeywordUI) {
        categoryUI.value?.let { category ->
            categoryUI.postValue(
                editCategoryUseCases.addKeyword(category, keyword)
            )
        }
    }

}