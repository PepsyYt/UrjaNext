package com.ravimaurya.urjanext.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun AlertDialogUrja(
    title: String,
    text: String = "",
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
){

    AlertDialog(
        title = { Text(title) },
        text = { Text(text) },
        confirmButton = {
            Button(
                onClick = { onConfirmClick() }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismissClick() }
            ) {
                Text("Cancel")
            }
        },
        onDismissRequest = {
            onDismissClick()
        }
    )

}