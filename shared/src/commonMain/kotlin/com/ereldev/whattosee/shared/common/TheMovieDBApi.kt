package com.ereldev.whattosee.shared.common

import io.ktor.client.*
import io.ktor.client.request.*

abstract class TheMovieDBApi(
    protected val httpClient: HttpClient = HttpClientFactory.buildClient()
) {

    protected fun addQueryParameters(query: HttpRequestBuilder) =
        query.apply {
            //parameter("api_key", BuildKonfig.themoviedbApiKey)
            //parameter("language", Platform().language)
        }

    companion object {
        const val API_URL = "https://api.themoviedb.org/3"
    }

}