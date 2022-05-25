package com.ereldev.whattosee.android

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ereldev.whattosee.android.category.edit.CATEGORY_EDIT_SCREEN
import com.ereldev.whattosee.android.category.edit.CategoryEditScreenVM
import com.ereldev.whattosee.android.category.list.CATEGORIES_SCREEN
import com.ereldev.whattosee.android.category.list.CategoriesScreenVM
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
                onEditCategoryClick = { onEditCategoryClick(navController, it) }
            )
        }
        composable(CATEGORY_EDIT_SCREEN) {
            CreateEditCategoryScreen(navController)
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

@ExperimentalMaterialApi
@Composable
private fun CreateEditCategoryScreen(navController: NavHostController) {
    /*navController.previousBackStackEntry?.arguments?.getParcelable<CategoryUI>(
        DETAIL_SCREEN_ARG_SHOW
    ).let {
        CategoryEditScreenVM(it) { onBackPressed(navController) }
    }*/
    CategoryEditScreenVM(
        initialCategoryUI = null,
        onBackPressed = { onBackPressed(navController) },
        onCategorySaved = { navController.navigateUp() }
    )
}

private fun onEditCategoryClick(
    navController: NavController,
    categoryUI: CategoryUI?
) {
    navController.navigate(CATEGORY_EDIT_SCREEN)
}

private fun onCategoryClick(
    navController: NavController,
    categoryUI: CategoryUI
) {
    navController.navigate(SHOWS_SCREEN)
}

private fun onBackPressed(navController: NavController) {
    navController.navigateUp()
}