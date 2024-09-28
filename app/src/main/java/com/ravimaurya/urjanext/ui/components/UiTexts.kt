package com.ravimaurya.urjanext.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NormalText(
    modifier: Modifier,
    text: String,
    color: Color
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        textAlign = TextAlign.Center
    )
}
@Composable
fun DisplayLargeText(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge
    )
}
@Composable
fun DisplayMediumText(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge
    )
}