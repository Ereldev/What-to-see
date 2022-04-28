package com.ereldev.whattosee.android.category.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.category.common.KeywordsList
import com.ereldev.whattosee.android.component.MainTopAppBar
import com.ereldev.whattosee.android.component.TextTitle2
import com.ereldev.whattosee.android.component.ValidIconButton
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryUI
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

const val CATEGORY_EDIT_SCREEN = "category_edit_screen"

@Composable
fun CategoryEditScreenVM(
    initialCategoryUI: CategoryUI?,
    onBackPressed: () -> Unit
) {
    val viewModel by viewModel<CategoryEditViewModel> { parametersOf(initialCategoryUI) }

    val categoryUI by viewModel.categoryUI.observeAsState()
    val currentSearch by viewModel.currentSearch.observeAsState("")

    categoryUI?.let {
        CategoryEditScreen(
            categoryUI = it,
            currentSearch = currentSearch,
            onBackPressed = { onBackPressed() },
            onValidClick = { viewModel.onValidClick() },
            onNameChange = { name -> viewModel.onNameChange(name) },
            onSearchKeywordChange = { search -> viewModel.onSearchKeywordChange(search) }
        )
    }
}

@Composable
fun CategoryEditScreen(
    categoryUI: CategoryUI,
    currentSearch: String,
    onBackPressed: () -> Unit,
    onValidClick: () -> Unit,
    onNameChange: (name: String) -> Unit,
    onSearchKeywordChange: (search: String) -> Unit
) {
    Scaffold(
        topBar = {
            MainTopAppBar(
                title = stringResource(R.string.create_category_title),
                actions = { ValidIconButton { onValidClick() } },
                onBackPressed = { onBackPressed() }
            )
        },
    ) {
        Column {
            TextTitle2(text = stringResource(R.string.category_name))

            OutlinedTextField(
                value = categoryUI.name,
                label = { Text(text = stringResource(R.string.category_name_label)) },
                singleLine = true,
                onValueChange = { onNameChange(it) },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
            )

            TextTitle2(text = stringResource(R.string.category_keywords))

            KeywordsList(
                keywords = categoryUI.keywords,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            OutlinedTextField(
                value = currentSearch,
                label = { Text(text = stringResource(R.string.category_keywords_label)) },
                singleLine = true,
                onValueChange = { onSearchKeywordChange(it) },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
            )

            // Search result
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoryEditScreenPreview() {
    CategoryEditScreen(
        categoryUI = CategoryFactory.getCategory(),
        currentSearch = "test search",
        onBackPressed = {},
        onValidClick = {},
        onNameChange = {},
        onSearchKeywordChange = {}
    )
}