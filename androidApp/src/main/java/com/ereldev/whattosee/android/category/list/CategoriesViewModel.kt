package com.ereldev.whattosee.android.category.list

import androidx.lifecycle.MutableLiveData
import com.ereldev.whattosee.android.common.AbstractViewModel
import com.ereldev.whattosee.shared.category.GetCategoriesUseCase
import com.ereldev.whattosee.shared.category.model.CategoryUI

class CategoriesViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
): AbstractViewModel() {

    val categories: MutableLiveData<List<CategoryUI>> by lazy {
        MutableLiveData<List<CategoryUI>>()
    }

    init {
        request({ getCategoriesUseCase.execute() },
            {
                categories.postValue(it)
            }, {
                print("")
            }
        )
    }

}