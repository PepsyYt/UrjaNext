package com.ravimaurya.urjanext.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneEnabled
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ravimaurya.urjanext.R

@Composable
fun RegistrationContent(){

    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Maharashtra", "Uttar Pradesh", "Delhi")
    var selectedItem by remember { mutableStateOf("Select State") }
    var userName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // User Name Field
        Text(
            text = stringResource(R.string.your_name),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.your_name)) },
            value = userName,
            onValueChange = {
                userName = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = ""
                )
            },
            shape = ShapeDefaults.ExtraLarge,
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,
                unfocusedLeadingIconColor = Color.Gray
            )
        )

        // Region/State Field
        Text(
            text = stringResource(R.string.select_region),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
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
                    imageVector = if(expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            shape = ShapeDefaults.ExtraLarge,
            textStyle = MaterialTheme.typography.bodyMedium
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach {
                DropdownMenuItem(
                    text = {
                        Text(it)
                    },
                    onClick = {
                        expanded = false
                        selectedItem = it
                    }
                )
            }
        }

        // Phone Number Field
        Text(
            text = stringResource(R.string.phone_number),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.enter_phone)) },
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.PhoneEnabled,
                    contentDescription = ""
                )
            },
            shape = ShapeDefaults.ExtraLarge,
            textStyle = MaterialTheme.typography.bodyMedium
        )
        // Password Field
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.enter_password)) },
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = ""
                )
            },
            shape = ShapeDefaults.ExtraLarge,
            textStyle = MaterialTheme.typography.bodyMedium
        )

    }
}