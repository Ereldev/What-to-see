package com.ereldev.whattosee.android.category.edit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI

@Composable
fun CategoryKeywordListItem(
    categoryKeywordUI: CategoryKeywordUI,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = categoryKeywordUI.name,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun CategoryKeywordListItemPreview() {
    CategoryKeywordListItem(
        CategoryFactory.getCategory().keywords.first()
    ) {}
}