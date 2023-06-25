package com.findandhire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.findandhire.ui.screens.LoginScreen
import com.findandhire.ui.screens.home_screen.HomeScreen
import com.findandhire.ui.screens.sign_up_screen.RegistrationViews
import com.findandhire.ui.screens.sign_up_screen.SignUpScreen
import com.findandhire.ui.theme.FindHireTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindHireTheme {
                // A surface container using the 'background' color from the theme
                FindAndHireNavHost()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultLoginPreview() {
    FindHireTheme {
        LoginScreen()
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultSignUpPreview() {
    FindHireTheme {
        SignUpScreen()
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultDashboardPreview() {
    FindHireTheme {
        HomeScreen()
    }
}