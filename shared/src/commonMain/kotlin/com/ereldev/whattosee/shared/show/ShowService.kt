package com.ereldev.whattosee.shared.show

import com.ereldev.whattosee.shared.common.DateUtils
import com.ereldev.whattosee.shared.common.ResponseDto
import com.ereldev.whattosee.shared.common.TheMovieDBApi
import com.ereldev.whattosee.shared.show.model.MovieTo
import com.ereldev.whattosee.shared.show.model.TVShowTo
import io.ktor.client.call.*
import io.ktor.client.request.*

class ShowService: TheMovieDBApi() {

    companion object {
        const val POSTER_URL = "https://image.tmdb.org/t/p/w154"
        const val BACKGROUND_URL = "https://image.tmdb.org/t/p/w500"

        private const val DISCOVER_MOVIE_PATH = "/discover/movie"
        private const val DISCOVER_TV_PATH = "/discover/tv"
    }

    suspend fun getMovies(keywords: List<String>): ResponseDto<List<MovieTo>> =
        httpClient.get("$API_URL$DISCOVER_MOVIE_PATH") {
            addQueryParameters(this)
            parameter("with_keywords", keywords.joinToString(","))
            parameter("sort_by", "release_date.asc")
            parameter("release_date.gte", DateUtils.nowMinusOneMonth())
        }.body()

    suspend fun getTVShows(keywords: List<String>): ResponseDto<List<TVShowTo>> =
        httpClient.get("$API_URL$DISCOVER_TV_PATH") {
            addQueryParameters(this)
            parameter("with_keywords", keywords.joinToString(","))
            parameter("sort_by", "first_air_date.asc")
            parameter("air_date.gte", DateUtils.nowMinusOneMonth())
        }.body()

}