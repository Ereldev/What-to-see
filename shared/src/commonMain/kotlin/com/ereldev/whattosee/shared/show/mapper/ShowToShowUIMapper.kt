package com.ereldev.whattosee.shared.show.mapper

import com.ereldev.whattosee.shared.common.Mapper
import com.ereldev.whattosee.shared.show.model.Show
import com.ereldev.whattosee.shared.show.model.ShowUI

class ShowToShowUIMapper: Mapper<Show, ShowUI>() {

    override fun from(from: Show) = ShowUI(
        from.title,
        from.date,
        from.overview,
        from.backgroundUrl,
        from.imageUrl
    )

}