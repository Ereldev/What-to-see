package com.ereldev.whattosee.shared.category.mapper

import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.KeywordTo
import com.ereldev.whattosee.shared.common.Mapper

class KeywordToToCategoryKeywordUIMapper: Mapper<KeywordTo, CategoryKeywordUI>() {

    override fun from(from: KeywordTo) = CategoryKeywordUI(
        from.id,
        from.name
    )

}