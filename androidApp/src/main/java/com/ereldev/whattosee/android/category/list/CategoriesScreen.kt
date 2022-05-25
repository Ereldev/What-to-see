package com.ereldev.whattosee.android.category.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.category.common.EmptyState
import com.ereldev.whattosee.android.component.MainTopAppBar
import com.ereldev.whattosee.android.component.SettingsIconButton
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryUI
import org.koin.androidx.compose.viewModel

const val CATEGORIES_SCREEN = "categories_screen"

@ExperimentalMaterialApi
@Composable
fun CategoriesScreenVM(
    onCategoryClick: (categoryUI: CategoryUI) -> Unit,
    onEditCategoryClick: (categoryUI: CategoryUI?) -> Unit
) {
    val viewModel by viewModel<CategoriesViewModel>()

    val categories by viewModel.categories.observeAsState(listOf())

    // Force refresh screen after editing a category
    LaunchedEffect(Unit) {
        viewModel.loadCategories()
    }

    CategoriesScreen(
        categories = categories,
        onCategoryClick= onCategoryClick,
        onEditCategoryClick = onEditCategoryClick
    )
}

@ExperimentalMaterialApi
@Composable
fun CategoriesScreen(
    categories: List<CategoryUI>,
    onCategoryClick: (categoryUI: CategoryUI) -> Unit,
    onEditCategoryClick: (categoryUI: CategoryUI?) -> Unit
) {
    Scaffold(
        topBar = {
            MainTopAppBar(
                title = stringResource(R.string.app_name),
                actions = { SettingsIconButton() }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { onEditCategoryClick(null) }) {
                Text("+")
            }
        }
    ) {
        if (categories.isEmpty()) {
            EmptyState(stringResource(R.string.categories_empty_state))
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryListItem(category) {
                        onCategoryClick(category)
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen(
        categories = listOf(
            CategoryFactory.getCategory(),
            CategoryFactory.getCategory()
        ),
        onCategoryClick = {},
        onEditCategoryClick = {}
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun CategoriesScreenEmptyStatePreview() {
    CategoriesScreen(
        categories = listOf(),
        onCategoryClick = {},
        onEditCategoryClick = {}
    )
}