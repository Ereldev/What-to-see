package com.ereldev.whattosee.android.category.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmptyState(
    message: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            text = message
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyStatePreview() {
    EmptyState(
        "This is an empty state\nWith two lines"
    )
}