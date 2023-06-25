@file:OptIn(ExperimentalMaterial3Api::class)

package com.findandhire.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.findandhire.ApplicationRoutes
import com.findandhire.R
import com.findandhire.ui.commons_widgets.DashboardAppBar
import com.findandhire.ui.commons_widgets.HorizontalSpacer
import com.findandhire.ui.commons_widgets.SimpleAlertDialog
import com.findandhire.ui.commons_widgets.VerticalSpacer
import com.findandhire.ui.screens.home_screen.home_page.HomePage
import com.findandhire.ui.screens.home_screen.map_page.MapPage
import com.findandhire.ui.screens.home_screen.profile_page.ProfilePage
import com.findandhire.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController? = null) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val selectedMenuIndex = remember {
        mutableStateOf(0)
    }

    val showAlert = remember {
        mutableStateOf(false)
    }

    val navHomeController = rememberNavController()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp)    // or your desired width
                    .fillMaxHeight()
            ) {
                DrawerView(selectedMenuIndex.value) { selectedIndex, homeNavigationItem ->
                    scope.launch {
                        drawerState.close()
                        if (homeNavigationItem.route != HomeNavigationItems.Logout.route) {
                            navHomeController.navigate(homeNavigationItem.route)
                        }
                        when (selectedIndex) {
                            1 -> {
                                selectedMenuIndex.value = selectedIndex
                            }
                            0 -> {
                                selectedMenuIndex.value = selectedIndex
                            }
                            3 -> {
                                showAlert.value = true
                            }
                            2 -> {
                                selectedMenuIndex.value = selectedIndex
                            }
                        }
                    }
                }
            }

        },
        drawerState = drawerState,
        content = {
            Surface(Modifier.fillMaxSize()) {
                Scaffold(
                    topBar = {
                        DashboardAppBar {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    },
                    content = {
                        Surface(modifier = Modifier.padding(it)) {
                            HomeNavigation(navHomeController)
                            if (showAlert.value) {
                                SimpleAlertDialog(
                                    title = "Confirmation.",
                                    text = "Are you sure want to logout?"
                                ) { isYesClicked ->
                                    if (isYesClicked) {
                                        navController?.navigate(ApplicationRoutes.LOGIN) {
                                            popUpTo(ApplicationRoutes.HOMEPAGE) {
                                                inclusive = true
                                            }
                                        }
                                    } else {
                                        showAlert.value = false
                                    }
                                }
                            }
                        }
                    },
                )
            }
        }
    )
}

@Composable
fun DrawerView(selectedIndex: Int, onMenuClicked: (Int, HomeNavigationItems) -> Unit) {
    val menuList = listOf(
        HomeNavigationItems.Home,
        HomeNavigationItems.Profile,
        HomeNavigationItems.Location,
        HomeNavigationItems.Logout
    )
    Column(modifier = Modifier.fillMaxSize()) {
        DrawerHeader()
        Divider(
            color = LIGHTGRAY,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .alpha(0.5f)
        )
        VerticalSpacer(size = 20f)
        LazyColumn {
            items(menuList.size) { menuIndex ->
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(60.dp)
                            .clip(shape = CircleShape)
                            .background(
                                color = if (selectedIndex == menuIndex) {
                                    LIGHTAPPCOLOR
                                } else {
                                    Color.Transparent
                                }
                            )
                            .clickable {
                                onMenuClicked(menuIndex, menuList[menuIndex])
                            },
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 16.dp,
                                end = 16.dp
                            )
                        ) {
                            val menuItem = menuList.get(index = menuIndex)
                            Icon(
                                painter = painterResource(id = menuItem.icon),
                                "",
                                modifier = Modifier.size(26.dp),
                                tint = if (selectedIndex == menuIndex) {
                                    AppColor
                                } else {
                                    GRAY
                                }
                            )
                            HorizontalSpacer(size = 10f)
                            Text(
                                text = menuItem.title,
                                color = if (selectedIndex == menuIndex) {
                                    AppColor
                                } else {
                                    GRAY
                                },
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.5.sp
                            )
                        }
                    }
                }
                VerticalSpacer(size = 10f)
            }
        }
    }
}

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 30.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.deafult_employe),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(85.dp)
                    .border(width = 1.5.dp, color = AppColor, CircleShape)
                    .padding(5.dp)
            )
            VerticalSpacer(size = 10f)
            Text(
                modifier = Modifier.wrapContentSize().padding(start = 8.dp),
                text = "Rohan",
                color = AppColor,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            VerticalSpacer(size = 3f)
            Text(
                modifier = Modifier.wrapContentSize().padding(start = 8.dp),
                text = "Android Developer",
                color = GRAY,
                fontSize = 14.sp
            )
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = GRAY)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultHomeScreenPreview() {
    FindHireTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultDrawerPreview() {
    val homeFun: (Int, HomeNavigationItems) -> Unit = { index, h ->
    }
    FindHireTheme {
        DrawerView(0, onMenuClicked = homeFun)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultHomePagePreview() {
    FindHireTheme {
        HomePage()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultMapPreview() {
    FindHireTheme {
        MapPage()
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultProfilePreview() {
    FindHireTheme {
        ProfilePage()
    }
}