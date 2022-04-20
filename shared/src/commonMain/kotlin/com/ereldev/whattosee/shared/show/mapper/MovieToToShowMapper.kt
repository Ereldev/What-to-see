package com.ereldev.whattosee.shared.show.mapper

import com.ereldev.whattosee.shared.common.DateUtils
import com.ereldev.whattosee.shared.common.Mapper
import com.ereldev.whattosee.shared.show.ShowService
import com.ereldev.whattosee.shared.show.model.MovieTo
import com.ereldev.whattosee.shared.show.model.Show
import com.ereldev.whattosee.shared.show.model.ShowType

class MovieToToShowMapper: Mapper<MovieTo, Show>() {

    override fun from(from: MovieTo) = Show(
        ShowType.MOVIE,
        from.id,
        from.title ?: "",
        from.overview ?: "",
        from.releaseDate ?:"",
        from.releaseDate?.let { DateUtils.formatDate(it) } ?: "",
        from.posterPath?.let { "${ShowService.POSTER_URL}$it" },
        from.backdropPath?.let { "${ShowService.BACKGROUND_URL}$it" }
    )

}