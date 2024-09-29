package com.ravimaurya.urjanext.ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ravimaurya.urjanext.R
import com.ravimaurya.urjanext.ui.components.BigButton
import com.ravimaurya.urjanext.ui.theme.Green40
import kotlinx.coroutines.launch
import kotlin.math.exp

@Composable
fun RegistrationScreen(){

    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 40.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(42.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "icon",
                    tint = Green40
                )
                Text(
                    text = stringResource(R.string.welcome_to_urjanext),
                    style = MaterialTheme.typography.displaySmall
                )

                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    contentColor = Color.Black,
                    containerColor = Color.White,
                    divider = {},
                    indicator = { tabPosition ->
                        TabRowDefaults.SecondaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPosition[pagerState.currentPage]),
                            height = 2.dp,
                            color = Green40
                        )
                    }
                ) {
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = {
                            Text(text = stringResource(R.string.register))
                        },
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 0)
                            }
                        },

                    )
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = {
                            Text(text = stringResource(R.string.login))
                        },
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 1)
                            }
                        }
                    )
                }

                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = false
                ) {
                    when (pagerState.currentPage) {
                        0 -> Registration()
                        1 -> Login()
                    }
                }
            }
        }

        // Continue or Login
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            BigButton(
                label = R.string.continue_,
                enabled = false,
                onClick = {

                }
            )
            Text(
                text = stringResource(R.string.have_an_account_login),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}

@Composable
fun Registration(){
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
                     imageVector = if(expanded)Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
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
@Composable
fun Login(){
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    RegistrationScreen()
}

