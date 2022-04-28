package com.ereldev.whattosee.shared.category

import com.ereldev.whattosee.shared.category.model.KeywordTo
import com.ereldev.whattosee.shared.common.ResponseDto
import com.ereldev.whattosee.shared.common.TheMovieDBApi
import io.ktor.client.call.*
import io.ktor.client.request.*

class KeywordService: TheMovieDBApi() {

    companion object {
        private const val SEARCH_KEYWORD_PATH = "/search/keyword"
    }

    suspend fun search(search: String): ResponseDto<List<KeywordTo>> =
        httpClient.get("$API_URL${SEARCH_KEYWORD_PATH}") {
            addQueryParameters(this)
            parameter("query", search)
        }.body()

}