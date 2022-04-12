package com.ereldev.whattosee.android.show

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showModule = module {

    viewModel { ShowViewModel() }

}