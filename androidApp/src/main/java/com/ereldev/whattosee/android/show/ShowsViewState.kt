package com.ereldev.whattosee.android.show

import com.ereldev.whattosee.shared.show.model.ShowsUI

sealed class ShowsViewState {
    object Loading: ShowsViewState()
    data class Error(val throwable: Throwable): ShowsViewState()
    data class Success(val showsUI: ShowsUI): ShowsViewState()
}