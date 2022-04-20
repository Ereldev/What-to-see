package com.ereldev.whattosee.shared.show.mapper

import com.ereldev.whattosee.shared.common.DateUtils
import com.ereldev.whattosee.shared.common.Mapper
import com.ereldev.whattosee.shared.show.ShowService
import com.ereldev.whattosee.shared.show.model.Show
import com.ereldev.whattosee.shared.show.model.ShowType
import com.ereldev.whattosee.shared.show.model.TVShowTo

class TVShowToToShowMapper: Mapper<TVShowTo, Show>() {

    override fun from(from: TVShowTo) = Show(
        ShowType.TV,
        from.id,
        from.name ?: "",
        from.overview ?: "",
        from.firstAirDate ?:"",
        from.firstAirDate?.let { DateUtils.formatDate(it) } ?: "",
        from.posterPath?.let { "${ShowService.POSTER_URL}$it" },
        from.backdropPath?.let { "${ShowService.BACKGROUND_URL}$it" }
    )

}