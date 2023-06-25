package com.findandhire

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.findandhire.ui.screens.LoginScreen
import com.findandhire.ui.screens.home_screen.HomeScreen
import com.findandhire.ui.screens.sign_up_screen.SignUpScreen
@Composable
fun FindAndHireNavHost(navHostController: NavHostController = rememberNavController()){
    NavHost(navController = navHostController, startDestination = ApplicationRoutes.LOGIN){
        composable(ApplicationRoutes.LOGIN){
            LoginScreen(navHostController)
        }
        composable(ApplicationRoutes.SIGNUP){
            SignUpScreen(navHostController)
        }
        composable(ApplicationRoutes.HOMEPAGE){
            HomeScreen(navHostController)
        }
    }
}