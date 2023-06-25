package com.findandhire.ui.screens.home_screen

import com.findandhire.R

sealed class HomeNavigationItems(var route: String, var icon: Int, var title: String) {
    object Home : HomeNavigationItems("home", R.drawable.home_icon, "Home")
    object Profile : HomeNavigationItems("profile", R.drawable.profile_icon, "Profile")
    object Location : HomeNavigationItems("location", R.drawable.location_icon, "Location")
    object Logout : HomeNavigationItems("share", R.drawable.logout_icon, "Logout")
}