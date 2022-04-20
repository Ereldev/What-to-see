package com.ereldev.whattosee.android.show

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.whattosee.shared.show.model.ShowsUI
import org.koin.androidx.compose.viewModel

const val SHOWS_SCREEN = "shows_screen"

@Composable
fun ShowsScreenVM() {
    val viewModel by viewModel<ShowsViewModel>()

    val viewState by viewModel.viewState.observeAsState(ShowsViewState.Loading)

    ShowsScreen(viewState)
}

@Composable
fun ShowsScreen(
    viewState: ShowsViewState
) {
}

@Preview(showSystemUi = true)
@Composable
fun ShowsScreenSuccessPreview() {
    ShowsScreen(
        ShowsViewState.Success(
            ShowsUI(listOf(), listOf())
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun ShowsScreenLoadingPreview() {
    ShowsScreen(
        ShowsViewState.Loading
    )
}

@Preview(showSystemUi = true)
@Composable
fun ShowsScreenErrorPreview() {
    ShowsScreen(
        ShowsViewState.Error(Exception(""))
    )
}