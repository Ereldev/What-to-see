package com.ereldev.whattosee.android.show

import androidx.lifecycle.MutableLiveData
import com.ereldev.whattosee.android.common.AbstractViewModel
import com.ereldev.whattosee.shared.show.GetShowsUseCase

class ShowsViewModel(
    private val getShowsUseCase: GetShowsUseCase
): AbstractViewModel() {

    val viewState: MutableLiveData<ShowsViewState> by lazy {
        MutableLiveData<ShowsViewState>()
    }

    init {
        request({ getShowsUseCase.execute(listOf("180547")) },
            {
                viewState.postValue(ShowsViewState.Success(it))
            },
            {
                viewState.postValue(ShowsViewState.Error(it))
            })
    }

}