package com.ravimaurya.urjanext.presentation.components

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBackTopAppBar(
    title: String,
    onBackClick: () -> Unit
){
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() }
            ) {
                Icon(Icons.Filled.ArrowBackIosNew, "")
            }
        }
    )
}