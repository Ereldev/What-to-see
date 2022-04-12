package com.ereldev.whattosee.android.category

import androidx.lifecycle.MutableLiveData
import com.ereldev.whattosee.android.common.AbstractViewModel
import com.ereldev.whattosee.shared.category.GetCategoriesUseCase
import com.ereldev.whattosee.shared.category.modelui.CategoryModelUI

class CategoriesViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
): AbstractViewModel() {

    val categories: MutableLiveData<List<CategoryModelUI>> by lazy {
        MutableLiveData<List<CategoryModelUI>>()
    }

    init {
        request({ getCategoriesUseCase.execute() },
            {
                categories.postValue(it)
            }, {

            }
        )
    }

}