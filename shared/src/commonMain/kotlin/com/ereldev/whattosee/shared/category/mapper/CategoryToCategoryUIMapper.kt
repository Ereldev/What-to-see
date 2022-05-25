package com.ereldev.whattosee.shared.category.mapper

import com.ereldev.whattosee.db.Category
import com.ereldev.whattosee.shared.category.model.CategoryUI
import com.ereldev.whattosee.shared.common.Mapper

class CategoryToCategoryUIMapper: Mapper<Category, CategoryUI>() {

    override fun from(from: Category) = CategoryUI(
        from.id,
        from.name,
        listOf()
    )

    override fun to(to: CategoryUI) = Category(
        0,
        to.name
    )

}