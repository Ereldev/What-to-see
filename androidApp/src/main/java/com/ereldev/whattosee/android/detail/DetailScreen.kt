package com.ereldev.whattosee.android.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.whattosee.android.R
import com.ereldev.whattosee.modelui.ShowUI

const val DETAIL_SCREEN = "detail_screen"

@Composable
fun DetailScreen(
    showUI: ShowUI
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            /*ShowImage(
                url = show.background,
                description = show.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )*/
            /*Box(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                PosterImage(
                    url = show.image,
                    description = show.title,
                    modifier = Modifier
                        .width(87.dp)
                        .height(125.dp)
                )
            }*/
        }

        //Title1(text = show.title)
        Text(text = showUI.title)

        Text(
            text = stringResource(R.string.release_date, showUI.date),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Column(
            //Modifier
                //.verticalScroll(scrollState)
        ) {
            //Title2(text = stringResource(R.string.synopsis))
            Text(text = stringResource(R.string.synopsis))
            Text(text = showUI.synopsis, modifier = Modifier.padding(8.dp))

            //Title2(text = stringResource(R.string.cast))
            Text(text = stringResource(R.string.cast))

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