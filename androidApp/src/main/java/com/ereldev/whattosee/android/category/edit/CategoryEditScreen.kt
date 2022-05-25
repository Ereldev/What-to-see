package com.ereldev.whattosee.android.category.edit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.category.common.KeywordsList
import com.ereldev.whattosee.android.component.MainTopAppBar
import com.ereldev.whattosee.android.component.TextTitle2
import com.ereldev.whattosee.android.component.ValidIconButton
import com.ereldev.whattosee.shared.category.factory.CategoryFactory
import com.ereldev.whattosee.shared.category.model.CategoryKeywordUI
import com.ereldev.whattosee.shared.category.model.CategoryUI
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

const val CATEGORY_EDIT_SCREEN = "category_edit_screen"

@Composable
fun CategoryEditScreenVM(
    initialCategoryUI: CategoryUI?,
    onBackPressed: () -> Unit,
    onCategorySaved: () -> Unit
) {
    val viewModel by viewModel<CategoryEditViewModel> {
        parametersOf(initialCategoryUI, onCategorySaved)
    }

    val categoryUI by viewModel.categoryUI.observeAsState()
    val currentSearch by viewModel.currentSearch.observeAsState("")
    val keywordsUIState by viewModel.keywordsUIState.observeAsState(CategoryKeywordsState.Loading)

    categoryUI?.let {
        CategoryEditScreen(
            categoryUI = it,
            currentSearch = currentSearch,
            keywordsUIState = keywordsUIState,
            onBackPressed = { onBackPressed() },
            onValidClick = { viewModel.onValidClick() },
            onNameChange = { name -> viewModel.onNameChange(name) },
            onRemoveKeyword = { keyword -> viewModel.onRemoveKeyword(keyword) },
            onSearchKeywordChange = { search -> viewModel.onSearchKeywordChange(search) },
            onRetrySearch = { viewModel.onRetrySearch() },
            onAddKeyword = { keyword -> viewModel.onAddKeyword(keyword) }
        )
    }
}

@Composable
fun CategoryEditScreen(
    categoryUI: CategoryUI,
    currentSearch: String,
    keywordsUIState: CategoryKeywordsState,
    onBackPressed: () -> Unit,
    onValidClick: () -> Unit,
    onNameChange: (name: String) -> Unit,
    onRemoveKeyword: (CategoryKeywordUI) -> Unit,
    onSearchKeywordChange: (search: String) -> Unit,
    onRetrySearch: () -> Unit,
    onAddKeyword: (CategoryKeywordUI) -> Unit
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
                modifier = Modifier.padding(bottom = 5.dp),
                onRemove = { onRemoveKeyword(it) }
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

            when (keywordsUIState) {
                is CategoryKeywordsState.Loading -> {}
                is CategoryKeywordsState.Success -> {
                    CategoryKeywordsList(keywordsUIState.keywordsUI) {
                        onAddKeyword(it)
                    }
                }
                is CategoryKeywordsState.Error -> {
                    Row(
                        horizontalArrangement= Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = { onRetrySearch() }) {
                            Text(text = stringResource(R.string.category_keywords_search_error))
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun CategoryKeywordsList(
    keywordsUI: List<CategoryKeywordUI>,
    onAddKeyword: (CategoryKeywordUI) -> Unit
) {
    if (keywordsUI.isEmpty()) {
        Text(
            text = stringResource(R.string.category_keywords_no_search_result),
            modifier = Modifier
                .padding(10.dp)
        )
    } else {
        LazyColumn {
            itemsIndexed(keywordsUI) { index, keywordUI ->
                CategoryKeywordListItem(keywordUI) { onAddKeyword(keywordUI) }

                if (index < keywordsUI.lastIndex) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoryEditScreenPreview() {
    CategoryEditScreen(
        categoryUI = CategoryFactory.getCategory(),
        currentSearch = "test search",
        keywordsUIState = CategoryKeywordsState.Success(
            CategoryFactory.getCategory().keywords
        ),
        onBackPressed = {},
        onValidClick = {},
        onNameChange = {},
        onRemoveKeyword = {},
        onSearchKeywordChange = {},
        onRetrySearch = {},
        onAddKeyword = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun CategoryEditScreenEmptyListPreview() {
    CategoryEditScreen(
        categoryUI = CategoryFactory.getCategory(),
        currentSearch = "test search",
        keywordsUIState = CategoryKeywordsState.Success(
            listOf()
        ),
        onBackPressed = {},
        onValidClick = {},
        onNameChange = {},
        onRemoveKeyword = {},
        onSearchKeywordChange = {},
        onRetrySearch = {},
        onAddKeyword = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun CategoryEditScreenSearchErrorPreview() {
    CategoryEditScreen(
        categoryUI = CategoryFactory.getCategory(),
        currentSearch = "test search",
        keywordsUIState = CategoryKeywordsState.Error(
            Throwable("")
        ),
        onBackPressed = {},
        onValidClick = {},
        onNameChange = {},
        onRemoveKeyword = {},
        onSearchKeywordChange = {},
        onRetrySearch = {},
        onAddKeyword = {}
    )
}