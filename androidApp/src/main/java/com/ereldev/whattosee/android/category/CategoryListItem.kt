package com.ereldev.whattosee.android.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.component.TextTitle2
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.modelui.CategoryModelUI

@ExperimentalMaterialApi
@Composable
fun CategoryListItem(
    categoryModelUI: CategoryModelUI,
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
            TextTitle2(text = categoryModelUI.name)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categoryModelUI.tags) { tag ->
                    Text(
                        text = tag.name,
                        modifier = Modifier
                            .background(
                                color = Color.LightGray,
                                shape = RoundedCornerShape(corner = CornerSize(8.dp))
                            )
                            .padding(start = 4.dp, end = 4.dp)
                    )
                }
            }
        }

    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(
        categoryModelUI = CategoryFactory.getCategory()
    ) {
        // Do nothing
    }
}