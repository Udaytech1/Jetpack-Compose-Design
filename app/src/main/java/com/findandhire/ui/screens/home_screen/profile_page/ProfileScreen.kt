package com.findandhire.ui.screens.home_screen.profile_page

import android.content.ContentValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.findandhire.ui.commons_widgets.VerticalSpacer
import com.findandhire.ui.theme.AppColor
import com.findandhire.ui.theme.FindHireTheme
import com.findandhire.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navHostHomeController: NavController? = null) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val getImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            Log.d(ContentValues.TAG, "RegistrationViews: $it")
            imageUri = it
        })

    var nameState by remember {
        mutableStateOf("")
    }
    var UsernameState by remember {
        mutableStateOf("")
    }
    var EmailState by remember {
        mutableStateOf("")
    }
    var FullAddressState by remember {
        mutableStateOf("")
    }
    var PhoneState by remember {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.padding(all = 16.dp)) {
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
                    ),
                    contentDescription = "",
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
                singleLine = true,
                value = nameState, onValueChange = { nameState = it },
                label = {
                    Text(
                        text = "Name",
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
                value = UsernameState, onValueChange = { UsernameState = it },
                label = {
                    Text(
                        text = "Username",
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
                value = EmailState, onValueChange = { EmailState = it },
                label = {
                    Text(
                        text = "Email",
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
                value = PhoneState, onValueChange = { PhoneState = it },
                label = {
                    Text(
                        text = "Phone",
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
                label = {
                    Text(
                        text = "Address",
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

                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
                colors = ButtonDefaults.buttonColors(Purple40)
            ) {
                Text(
                    text = "Update",
                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultProfilePreview() {
    FindHireTheme {
        ProfilePage()
    }
}