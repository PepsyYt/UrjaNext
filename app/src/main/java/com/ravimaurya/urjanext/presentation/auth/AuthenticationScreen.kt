package com.ravimaurya.urjanext.presentation.auth

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ravimaurya.urjanext.R
import com.ravimaurya.urjanext.presentation.components.BigButton
import com.ravimaurya.urjanext.theme.Green40
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun AuthPreview(){
    AuthenticationScreen()
}

@Composable
fun AuthenticationScreen(){

    AuthenticationContent()

}

@Composable
fun AuthenticationContent(){
    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                // Logo
                Icon(
                    modifier = Modifier.size(42.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "icon",
                    tint = Green40
                )

                // Welcome to UrjaNext
                Text(
                    text = stringResource(R.string.welcome_to_urjanext),
                    style = MaterialTheme.typography.displaySmall
                )

                // Register and Login TabRow
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
                    // Registration Tab
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = { Text(text = stringResource(R.string.register)) },
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(page = 0) }
                        },

                    )

                    // Login Tab
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = { Text(text = stringResource(R.string.login)) },
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(page = 1) }
                        }
                    )
                }

                // Registration or Login Content
                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = false
                ) {
                    when (pagerState.currentPage) {
                        0 -> RegistrationContent()
                        1 -> LoginContent()
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






