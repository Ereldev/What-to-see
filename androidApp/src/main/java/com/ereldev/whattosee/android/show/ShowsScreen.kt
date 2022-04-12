package com.ereldev.whattosee.android.show

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.viewModel

const val SHOWS_SCREEN = "shows_screen"

@Composable
fun ShowsScreenVM() {
    val viewModel by viewModel<ShowViewModel>()

    ShowsScreen()
}

@Composable
fun ShowsScreen() {
}

@Preview(showSystemUi = true)
@Composable
fun ShowsScreenPreview() {
    ShowsScreen()
}