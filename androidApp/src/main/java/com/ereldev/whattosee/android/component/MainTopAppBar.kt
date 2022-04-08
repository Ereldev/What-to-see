package com.ereldev.whattosee.android.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainTopAppBar(
    title: String
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = { /* open settings */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    )
}

@Preview
@Composable
fun MainTopAppBarPreview() {
    MainTopAppBar(
        "Title"
    )
}