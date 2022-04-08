package com.ereldev.whattosee.android.category

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.component.MainTopAppBar
import com.ereldev.whattosee.shared.category.modelui.CategoryModelUI
import org.koin.androidx.compose.viewModel

const val CATEGORIES_SCREEN = "categories_screen"

@Composable
fun CategoriesScreenVM(
    onCreateCategoryClick: () -> Unit
) {
    val viewModel by viewModel<CategoriesViewModel>()

    val categories by viewModel.categories.observeAsState(listOf())

    CategoriesScreen(
        categories = categories,
        onCreateCategoryClick = onCreateCategoryClick
    )
}

@Composable
fun CategoriesScreen(
    categories: List<CategoryModelUI>,
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
        LazyColumn {
            items(categories) { category ->
                Text(text = category.name)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen(
        categories = listOf()
    ) {
        // Do nothing
    }
}