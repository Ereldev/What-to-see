package com.ereldev.whattosee.shared.category.factory

import com.ereldev.whattosee.shared.category.modelui.CategoryModelUI
import com.ereldev.whattosee.shared.category.modelui.CategoryTagUI

class CategoryFactory {

    companion object {

        fun getCategory() = CategoryModelUI(
            "Category name",
            listOf(
                CategoryTagUI("1", "Tag name 1"),
                CategoryTagUI("2", "Tag name 2"),
                CategoryTagUI("3", "Tag name 3"),
                CategoryTagUI("4", "Tag name 4"),
                CategoryTagUI("5", "Tag name 5"),
            )
        )

    }

}