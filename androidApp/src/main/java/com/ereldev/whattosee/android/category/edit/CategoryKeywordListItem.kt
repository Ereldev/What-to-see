package com.ereldev.whattosee.android.category.edit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI

@ExperimentalMaterialApi
@Composable
fun CategoryKeywordListItem(
    categoryKeywordUI: CategoryKeywordUI,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = { onClick() }
    ) {
        Text(
            text = categoryKeywordUI.name,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CategoryKeywordListItemPreview() {
    CategoryKeywordListItem(
        CategoryFactory.getCategory().keywords.first()
    ) {}
}