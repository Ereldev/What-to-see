package com.ereldev.whattosee.android.category

import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.component.MainTopAppBar

const val CATEGORIES_SCREEN = "categories_screen"

@Composable
fun CategoriesScreen(
    onCreateCategoryClick: () -> Unit
) {
    Scaffold(
        topBar = { MainTopAppBar(title = stringResource(R.string.app_name)) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { onCreateCategoryClick() }) {
                Text("+")
            }
        }
    ) {

    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen {

    }
}