package com.findandhire.ui.screens.home_screen.map_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.findandhire.ui.screens.home_screen.home_page.HomePage
import com.findandhire.ui.theme.AppColor
import com.findandhire.ui.theme.FindHireTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*

@Composable
fun MapPage(navHostHomeController: NavController? = null) {
    val latLong = LatLng(26.846251,80.949028)
    val cameraPositionState = rememberCameraPositionState{
       position = CameraPosition.fromLatLngZoom(latLong,10f)
    }
    Surface(modifier = Modifier.fillMaxSize().background(color = AppColor)) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(
                    mapType = MapType.NORMAL
                )
            ){
                Marker(state = MarkerState(position = latLong),
                title = "Lucknow",
                snippet = "It's capital of Uttar Pradesh.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultMapPreview() {
    FindHireTheme {
        MapPage()
    }
}