package com.ereldev.whattosee.android.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}

@Preview
@Composable
fun TextTitle1Preview() {
    TextTitle1(text = "Text Title 1")
}

@Composable
fun TextTitle2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
fun TextTitle2Preview() {
    TextTitle2(text = "Text Title 2")
}