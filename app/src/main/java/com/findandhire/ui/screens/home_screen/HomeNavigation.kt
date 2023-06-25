package com.findandhire.ui.screens.home_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.findandhire.ui.screens.home_screen.home_page.HomePage
import com.findandhire.ui.screens.home_screen.map_page.MapPage
import com.findandhire.ui.screens.home_screen.profile_page.ProfilePage

@Composable
fun HomeNavigation(navHostHomeController: NavHostController = rememberNavController()){
    NavHost(navController = navHostHomeController, startDestination = HomeNavigationItems.Home.route ){
        composable(HomeNavigationItems.Home.route){
            HomePage(navHostHomeController)
        }
        composable(HomeNavigationItems.Profile.route){
            ProfilePage(navHostHomeController)
        }
        composable(HomeNavigationItems.Location.route){
            MapPage(navHostHomeController)
        }
    }
}