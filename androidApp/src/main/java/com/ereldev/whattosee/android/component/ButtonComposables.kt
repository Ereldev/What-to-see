package com.ereldev.whattosee.android.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CloseButton(
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
    ) {
        Text(
            text = "X",
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
fun CloseButtonPreview() {
    CloseButton {
        // Do nothing
    }
}