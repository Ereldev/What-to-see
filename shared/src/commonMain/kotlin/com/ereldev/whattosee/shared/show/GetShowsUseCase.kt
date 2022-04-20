package com.ereldev.whattosee.shared.show

import com.ereldev.whattosee.shared.show.mapper.ShowToShowUIMapper
import com.ereldev.whattosee.shared.show.model.ShowsUI
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class GetShowsUseCase(
    private val showRepository: ShowRepository,
    private val showToShowUIMapper: ShowToShowUIMapper
) {

    suspend fun execute(keywords: List<String>): ShowsUI {
        return coroutineScope {
            val moviesAsync = async { showRepository.getMovies(keywords) }
            val tvShowsAsync = async { showRepository.getTVShows(keywords) }

            // Wait for api calls to be done
            val movies = moviesAsync.await()
            val tvShows = tvShowsAsync.await()

            ShowsUI(
                movies.map { showToShowUIMapper.from(it) },
                tvShows.map { showToShowUIMapper.from(it) }
            )
        }
    }

}