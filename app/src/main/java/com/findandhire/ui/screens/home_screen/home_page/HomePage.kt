package com.findandhire.ui.screens.home_screen.home_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.findandhire.R
import com.findandhire.ui.theme.AppColor
import com.findandhire.ui.theme.FindHireTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navHostHomeController: NavController?=null) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(top = 10.dp, bottom = 10.dp)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(10) {
                val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
                Column(modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable {

                    }, horizontalAlignment = Alignment.CenterHorizontally) {
                    Surface() {
                        Card(
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 8.dp),
                            colors = CardDefaults.cardColors(Color(color))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.deafult_employe),
                                contentDescription = ""
                            )
                        }
                    }
                    Text(
                        text = "Ananya Patel",
                        color = AppColor,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                    )
                    Text(
                        text = "Android Developer",
                        color = Color(color),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        )
                    /*Text(text = "8858412652", color = Gray, textAlign = TextAlign.Center )
                    Text(text = "Lucknow, Uttar Pradesh 226021", textAlign = TextAlign.Center )*/

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultMainContentPreview() {
    FindHireTheme {
        HomePage()
    }
}