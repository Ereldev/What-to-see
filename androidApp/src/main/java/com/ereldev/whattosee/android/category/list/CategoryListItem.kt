package com.ereldev.whattosee.android.category.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.category.common.KeywordsList
import com.ereldev.whattosee.android.component.TextTitle2
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryUI

@ExperimentalMaterialApi
@Composable
fun CategoryListItem(
    categoryUI: CategoryUI,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
        ) {
            TextTitle2(text = categoryUI.name)

            KeywordsList(keywords = categoryUI.keywords)
        }

    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(
        categoryUI = CategoryFactory.getCategory()
    ) {
        // Do nothing
    }
}