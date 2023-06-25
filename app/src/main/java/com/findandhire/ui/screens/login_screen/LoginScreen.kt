package com.findandhire.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.findandhire.ApplicationRoutes
import com.findandhire.R
import com.findandhire.ui.commons_widgets.LoaderProgressBar
import com.findandhire.ui.commons_widgets.VerticalSpacer
import com.findandhire.ui.theme.*


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun LoginScreen(navController: NavController? = null) {
    var userId by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            SetLoginAnimation()
            VerticalSpacer(size = 10f)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), verticalArrangement = Arrangement.Top
            ) {
                OutlinedTextField(
                    value = userId,
                    onValueChange = { userId = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.enter_user_id),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.enter_user_id),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                    },
                    shape = CircleShape
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    label = {
                        Text(
                            text = stringResource(R.string.enter_password),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                    },
                    placeholder = {
                        Text(
                            text =  stringResource(R.string.enter_password),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                    shape = CircleShape,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Image(painter = if (passwordVisible) painterResource(id = R.drawable.password_visibility_off) else painterResource(
                            id = R.drawable.password_visible
                        ), contentDescription = "", modifier = Modifier.clickable {
                            passwordVisible = !passwordVisible
                        })
                    }
                )

                VerticalSpacer(10f)

                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp),
                    colors = ButtonDefaults.buttonColors(Purple40)
                ) {
                    Text(text = stringResource(R.string.sign_in), modifier = Modifier.padding(top = 7.dp, bottom = 7.dp))
                }

                OutlinedButton(
                    onClick = {
                        navController?.navigate(ApplicationRoutes.SIGNUP)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp),
                    border = BorderStroke(width = 1.dp, AppColor)
                ) {
                    Text(
                        text = stringResource(R.string.sign_up),
                        modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                        color = AppColor
                    )
                }
            }
        }
    }
}

@Composable
fun SetLoginAnimation() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.login))

    val lottiAnnotation by animateLottieCompositionAsState(
        composition,
        // Iterates Forever
        iterations = LottieConstants.IterateForever,
        // Lottie and pause/play
        isPlaying = true,
        // Increasing the speed of change Lottie
        speed = 0.1f,
        restartOnPlay = false
    )

    Surface(modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = AppColor,
                    shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                )
        ) {
            LottieAnimation(
                composition = composition,
                progress = lottiAnnotation,
                modifier = Modifier.size(280.dp),
            )
            if (isTraceInProgress()) {
                LoaderProgressBar()
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