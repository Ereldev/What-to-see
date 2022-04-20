package com.ereldev.whattosee.shared.show

import com.ereldev.whattosee.shared.common.DateUtils
import com.ereldev.whattosee.shared.show.mapper.MovieToToShowMapper
import com.ereldev.whattosee.shared.show.mapper.TVShowToToShowMapper
import com.ereldev.whattosee.shared.show.model.Show

class ShowRepository(
    private val showService: ShowService,
    private val movieToToShowMapper: MovieToToShowMapper,
    private val tvShowToToShowMapper: TVShowToToShowMapper
) {

    suspend fun getMovies(keywords: List<String>): List<Show> =
        showService
            .getMovies(keywords)
            .results
            // API returns certain shows even if date is passed
            .filter { (it.releaseDate != null && it.releaseDate >= DateUtils.nowMinusOneMonth()) }
            .map { movieToToShowMapper.from(it) }

    suspend fun getTVShows(keywords: List<String>): List<Show> =
        showService
            .getTVShows(keywords)
            .results
            // API returns certain shows even if date is passed
            .filter { (it.firstAirDate != null && it.firstAirDate >= DateUtils.nowMinusOneMonth()) }
            .map { tvShowToToShowMapper.from(it) }

}