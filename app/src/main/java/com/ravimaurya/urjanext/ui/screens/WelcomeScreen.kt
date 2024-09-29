package com.ravimaurya.urjanext.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.ravimaurya.urjanext.R
import com.ravimaurya.urjanext.ui.components.BigButton
import com.ravimaurya.urjanext.ui.components.NormalText
import com.ravimaurya.urjanext.ui.theme.Green40
import com.ravimaurya.urjanext.ui.util.Screens

@Composable
fun WelcomeScreen(navController: NavController){

    val linearGradientBG = listOf(
        Color(4, 197, 58),
        Color(209, 255, 77),
        Color.White,
        Color.White,
        Color.White
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                alpha = 0.5f,
                brush = Brush.linearGradient(colors = linearGradientBG)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight(0.6f)
//                .background(Color.Cyan)
                .padding( top = 40.dp, start = 29.dp, end = 29.dp)
            ,
            contentAlignment = Alignment.BottomCenter
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
            ){
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.iphone),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(40.dp)),
                    painter = painterResource(R.drawable.ev_charging),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }


        }


        // Text Column
        Column(
            modifier = Modifier
                .fillMaxWidth(0.87f)
                .height( 150.dp).zIndex(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.track_charging),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
             Text(
                text = stringResource(R.string.lorem_ipsum),
                 color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

        }

        // Button Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BigButton(
                label = R.string.continue_,
                onClick = {
                    // Navigate to Authentication
                    navController.navigate(Screens.RegistrationScreen.route)
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                        text = stringResource(R.string.learn_more),
                    style = MaterialTheme.typography.bodyMedium,
                        color = Green40
                )
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "",
                    tint = Green40
                )
            }
        }



    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomePreview(){
//    WelcomeScreen()
}

