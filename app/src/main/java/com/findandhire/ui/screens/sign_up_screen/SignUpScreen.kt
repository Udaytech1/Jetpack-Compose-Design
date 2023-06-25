package com.findandhire.ui.screens.sign_up_screen

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.findandhire.ApplicationRoutes
import com.findandhire.ui.theme.FindHireTheme
import com.findandhire.R
import com.findandhire.ui.commons_widgets.CommanAppBar
import com.findandhire.ui.commons_widgets.VerticalSpacer
import com.findandhire.ui.theme.AppColor
import com.findandhire.ui.theme.Purple40

@Composable
fun SignUpScreen(navController: NavController? = null) {
    RegistrationViews(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationViews(navController: NavController? = null) {

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val getImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            Log.d(TAG, "RegistrationViews: $it")
            imageUri = it
        })

    var nameState by remember {
        mutableStateOf("")
    }
    var UsernameState by remember {
        mutableStateOf("")
    }
    var PasswordState by remember {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var EmailState by remember {
        mutableStateOf("")
    }
    var FullAddressState by remember {
        mutableStateOf("")
    }
    var PhoneState by remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        CommanAppBar("Registration") {
            navController?.popBackStack()
        }
    },
        content = {
            Surface(modifier = Modifier.padding(it)) {
                Column(
                    verticalArrangement = Arrangement.Top, modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(
                            rememberScrollState()
                        )
                        .padding(top = 16.dp, bottom = 16.dp)

                ) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = ImageRequest.Builder(
                                    LocalContext.current
                                ).data(imageUri).build()
                            ), contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(shape = CircleShape)
                                .border(
                                    width = 1.dp, color = AppColor,
                                    CircleShape
                                )
                                .clickable {
                                    getImageLauncher.launch("image/*")
                                },
                        )
                    }
                    VerticalSpacer(size = 8f)
                    OutlinedTextField(

                        value = nameState, onValueChange = { nameState = it },
                        placeholder = {
                            Text(
                                text = "Enter name",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter name",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = CircleShape
                    )
                    OutlinedTextField(

                        value = UsernameState, onValueChange = { UsernameState = it },
                        placeholder = {
                            Text(
                                text = "Enter username",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter username",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = CircleShape
                    )
                    OutlinedTextField(

                        value = EmailState, onValueChange = { EmailState = it },
                        placeholder = {
                            Text(
                                text = "Enter email",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter email",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = CircleShape
                    )
                    OutlinedTextField(

                        value = PasswordState, onValueChange = { PasswordState = it },
                        placeholder = {
                            Text(
                                text = "Enter password",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter password",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = CircleShape,
                        trailingIcon = {
                            Image(painter = if (passwordVisible) painterResource(id = R.drawable.password_visibility_off) else painterResource(
                                id = R.drawable.password_visible
                            ), contentDescription = "", modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible
                            })
                        }
                    )
                    OutlinedTextField(

                        value = PhoneState, onValueChange = { PhoneState = it },
                        placeholder = {
                            Text(
                                text = "Enter phone",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter phone",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = CircleShape
                    )
                    OutlinedTextField(
                        singleLine = true,
                        value = FullAddressState, onValueChange = { FullAddressState = it },
                        placeholder = {
                            Text(
                                text = "Enter full address",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        label = {
                            Text(
                                text = "Enter full address",
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        shape = CircleShape
                    )

                    VerticalSpacer(10f)

                    Button(
                        onClick = {
                            navController?.navigate(ApplicationRoutes.HOMEPAGE) {
                                popUpTo(ApplicationRoutes.SIGNUP) {
                                    inclusive = true
                                }
                            }
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
                        colors = ButtonDefaults.buttonColors(Purple40)
                    ) {
                        Text(
                            text = "Register",
                            modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
                        )
                    }

                    OutlinedButton(
                        onClick = {
                            navController?.popBackStack()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
                        border = BorderStroke(width = 1.dp, AppColor)
                    ) {
                        Text(
                            text = "Sign In",
                            modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                            color = AppColor
                        )
                    }
                }
            }
        })

}

@Preview(showBackground = true)
@Composable
fun DefaultSignUpPreview() {
    FindHireTheme {
        SignUpScreen()
    }
}