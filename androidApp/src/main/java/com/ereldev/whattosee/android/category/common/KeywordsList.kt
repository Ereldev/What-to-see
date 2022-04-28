package com.ereldev.whattosee.android.category.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI

@Composable
fun KeywordsList(
    keywords: List<CategoryKeywordUI>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(keywords) { keyword ->
            Text(
                text = keyword.name,
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

@Preview(showSystemUi = true)
@Composable
fun KeywordsListPreview() {
    KeywordsList(
        CategoryFactory.getCategory().keywords
    )
}