package com.ereldev.whattosee.android.detail

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.android.component.*
import com.ereldev.whattosee.shared.show.modelui.ShowUI

const val DETAIL_SCREEN = "detail_screen"

@Composable
fun DetailScreen(
    showUI: ShowUI
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            BackgroundImage(
                url = showUI.backgroundUrl,
                description = showUI.title,
                placeHolder = R.drawable.movie_placeholder,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Box(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                PosterImage(
                    url = showUI.imageUrl,
                    description = showUI.title,
                    placeHolder = R.drawable.movie_placeholder,
                    modifier = Modifier
                        .width(87.dp)
                        .height(125.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 10.dp)
            ) {
                CloseButton { backDispatcher.onBackPressed() }
            }
        }

        TextTitle1(text = showUI.title)

        Text(
            text = stringResource(R.string.release_date, showUI.date),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Column(
            Modifier.verticalScroll(scrollState)
        ) {
            TextTitle2(text = stringResource(R.string.synopsis))
            Text(text = showUI.synopsis, modifier = Modifier.padding(8.dp))

            TextTitle2(text = stringResource(R.string.cast))

            /*when (screenStatus) {
                ScreenState.LOADING -> {
                    CastList(
                        modifier = Modifier
                            .height(200.dp)
                    )
                }
                ScreenState.ERROR -> {
                    ErrorWithRetry(
                        message = stringResource(id = R.string.unable_to_get_cast),
                        modifier = Modifier
                            .fillMaxSize()
                    ) { onLoadCastRetry?.let { it() } }
                }
                else -> {
                    CastList(
                        cast = cast,
                        modifier = Modifier
                            .height(200.dp)
                    )
                }
            }*/
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        ShowUI(
            "Sample Movie",
            "25/01/2000",
            "il était une fois ..."
        )
    )
}