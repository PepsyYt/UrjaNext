package com.ravimaurya.urjanext.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.ravimaurya.urjanext.R

@Composable
fun LoginContent(){


    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Maharashtra", "Uttar Pradesh", "Delhi")
    var selectedItem by remember { mutableStateOf("") }

    Column {
        Text(
            text = stringResource(R.string.select_region),
            style = MaterialTheme.typography.bodyLarge
        )
        OutlinedTextField(
            label = {},
            value = selectedItem,
            onValueChange = {
                selectedItem = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Home,
                    ""
                )
            },
            shape = ShapeDefaults.ExtraLarge
        )
    }
}