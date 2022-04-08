package com.ereldev.whattosee.android.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun BackgroundImage(
    url: String?,
    description: String?,
    @DrawableRes placeHolder: Int,
    modifier: Modifier = Modifier
) {
    CoilImage(
        imageModel = url ?: painterResource(placeHolder),
        placeHolder = painterResource(placeHolder),
        error = painterResource(placeHolder),
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun PosterImage(
    url: String?,
    description: String?,
    @DrawableRes placeHolder: Int,
    modifier: Modifier = Modifier
) {
    BackgroundImage(
        url = url,
        description = description,
        placeHolder = placeHolder,
        modifier = modifier
            .shadow(2.dp, shape = RoundedCornerShape(corner = CornerSize(5.dp)))
    )
}

@Preview
@Composable
fun BackgroundImagePreview() {
    BackgroundImage(
        url = "test.jpg",
        description = "test description",
        placeHolder = R.drawable.movie_placeholder,
        modifier = Modifier
            .width(77.dp)
            .height(115.dp)
    )
}

@Preview
@Composable
fun BackgroundImagePlaceHolderPreview() {
    BackgroundImage(
        url = null,
        description = null,
        placeHolder = R.drawable.movie_placeholder,
        modifier = Modifier
            .width(77.dp)
            .height(115.dp)
    )
}