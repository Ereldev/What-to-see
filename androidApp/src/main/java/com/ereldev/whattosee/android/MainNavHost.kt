package com.ereldev.whattosee.android

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ereldev.whattosee.android.category.CATEGORIES_SCREEN
import com.ereldev.whattosee.android.category.CategoriesScreenVM
import com.ereldev.whattosee.android.detail.DETAIL_SCREEN
import com.ereldev.whattosee.android.detail.DetailScreen
import com.ereldev.whattosee.android.show.SHOWS_SCREEN
import com.ereldev.whattosee.android.show.ShowsScreenVM
import com.ereldev.whattosee.shared.category.model.CategoryUI
import com.ereldev.whattosee.shared.show.model.ShowUI

@ExperimentalMaterialApi
@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = CATEGORIES_SCREEN
    ) {
        composable(CATEGORIES_SCREEN) {
            CategoriesScreenVM(
                onCategoryClick = { onCategoryClick(navController, it) },
                onCreateCategoryClick = { onCreateCategoryClick(navController) }
            )
        }
        composable(SHOWS_SCREEN) {
            ShowsScreenVM()
        }
        composable(DETAIL_SCREEN) {
            DetailScreen(
                ShowUI(
                    "Sample Movie",
                    "25/01/2000",
                    "il était une fois ..."
                )
            )
        }
    }
}

private fun onCategoryClick(
    navController: NavController,
    categoryUI: CategoryUI
) {
    navController.navigate(SHOWS_SCREEN)
}

private fun onCreateCategoryClick(navController: NavController) {
    navController.navigate(DETAIL_SCREEN)
}