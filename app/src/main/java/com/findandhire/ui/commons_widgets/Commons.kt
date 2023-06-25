package com.findandhire.ui.commons_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.findandhire.R
import com.findandhire.ui.theme.AppColor
import com.findandhire.ui.theme.GRAY
import com.findandhire.ui.theme.WhiteColor
import kotlinx.coroutines.launch

@Composable
fun VerticalSpacer(size: Float) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun HorizontalSpacer(size: Float) {
    Spacer(modifier = Modifier.width(size.dp))
}
@Composable
fun SimpleAlertDialog(title: String, text: String, onClickedEvent: (Boolean)->Unit) {
    AlertDialog(onDismissRequest = { }, confirmButton = {
        Text(text = "Yes",fontSize = 15.sp, modifier = Modifier
            .clickable {
                onClickedEvent(true)
            }
            .padding(all = 5.dp,), color = AppColor)
    }, dismissButton = {
        Text(text = "No",fontSize = 14.sp, modifier = Modifier
            .padding(all = 5.dp,)
            .clickable {
                onClickedEvent(false)
            }, color = GRAY)
    }, title = {
        Text(text = title, fontSize = 18.sp)
    },
        text = {
            Text(text = text,fontSize = 15.sp)
        },
        shape = MaterialTheme.shapes.extraLarge
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommanAppBar(title: String,startIconClicked:()->Unit){
    SmallTopAppBar(title = {
        Text(
            title,
            color = WhiteColor,
            modifier = Modifier.padding(start = 10.dp)
        )
    },
        colors = TopAppBarDefaults.smallTopAppBarColors(AppColor),
        navigationIcon = {
            IconButton(onClick = {
                startIconClicked()
            }, modifier = Modifier.clickable {
            }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = WhiteColor,
                    modifier = Modifier.size(30.dp)
                )
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardAppBar(menuIconClicked:()->Unit){
    SmallTopAppBar(title = {
        Text(
            "Find&Hire",
            fontWeight = FontWeight.Bold,
            color = WhiteColor,
            modifier = Modifier.padding(start = 10.dp)
        )
    },
        colors = TopAppBarDefaults.smallTopAppBarColors(AppColor),
        navigationIcon = {
            IconButton(onClick = {
                menuIconClicked()
            }, modifier = Modifier.clickable {
            }) {
                Icon(
                    painterResource(id = R.drawable.menu_icon),
                    contentDescription = "",
                    tint = WhiteColor,
                    modifier = Modifier.size(64.dp)
                )
            }
        }
    )
}
@Composable
fun LoaderProgressBar(){
    CircularProgressIndicator(color = AppColor)
}