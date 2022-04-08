package com.ereldev.whattosee.android.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AbstractViewModel: ViewModel() {

    fun <T> request(
        request: suspend () -> T,
        onSuccess: (result: T) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = request.invoke()

                viewModelScope.launch(Dispatchers.IO) { onSuccess(result) }
            } catch (t: Throwable) {
                viewModelScope.launch(Dispatchers.IO) { onError(t)  }
            }
        }
    }

}