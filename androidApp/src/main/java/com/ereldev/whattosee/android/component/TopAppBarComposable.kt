package com.ereldev.whattosee.android.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainTopAppBar(
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    onBackPressed: (() -> Unit)? = null
) {
    TopAppBar(
        navigationIcon = if (onBackPressed != null) {
            {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else null,
        title = { Text(text = title) },
        actions = actions
    )
}

@Composable
fun SettingsIconButton() {
    IconButton(onClick = { /* open settings */ }) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Settings"
        )
    }
}

@Composable
fun ValidIconButton(
    onCLick: () -> Unit
) {
    IconButton(onClick = { onCLick() }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Settings"
        )
    }
}

@Preview
@Composable
fun MainTopAppBarSettingsPreview() {
    MainTopAppBar(
        title = "Title",
        actions = {
            SettingsIconButton()
        }
    )
}

@Preview
@Composable
fun MainTopAppBarValidPreview() {
    MainTopAppBar(
        title = "Title",
        actions = {
            ValidIconButton {}
        },
        onBackPressed = {}
    )
}