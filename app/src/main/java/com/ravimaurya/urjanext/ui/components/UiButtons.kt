package com.ravimaurya.urjanext.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ravimaurya.urjanext.R
import com.ravimaurya.urjanext.ui.theme.Green40

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    label: Int,
    enabled: Boolean = true,
    onClick: ()-> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Green40
    )
){
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {
            onClick()
        },
        enabled = enabled,
        colors = colors,
        shape = ShapeDefaults.Medium
    ) {
        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = stringResource(label),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
