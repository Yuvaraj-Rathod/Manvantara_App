package com.example.manvantara.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.manvantara.R
import com.example.manvantara.viewmodel.AuthState
import com.example.manvantara.viewmodel.AuthViewModel

@Composable
fun SignUpPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var Username by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    var ConfirmPassword by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext
    val authState = authViewModel.authState.observeAsState()

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.finalsignup))
    var isPlaying by remember { mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever, speed = 1.0f)
    val keyboardController = LocalSoftwareKeyboardController.current

    val passwordFocusRequester = remember { FocusRequester() }

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.EmailVerificationSent -> {
                Toast.makeText(context, "Verification email sent! Please verify your email before logging in.", Toast.LENGTH_LONG).show()
            }
            is AuthState.Authenticated -> {
                val user = authViewModel.getCurrentUser() // Create a method in the ViewModel to get the current user
                if (user?.isEmailVerified == true) {
                    navController.navigate("homepage")
                } else {
                    Toast.makeText(context, "Please verify your email first.", Toast.LENGTH_LONG).show()
                }
            }
            is AuthState.Error -> {
                Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(16.dp)){

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 30.dp, top = 30.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 6.dp),
            verticalArrangement = Arrangement.Bottom,
            Alignment.CenterHorizontally,

            ) {
            OutlinedTextField(
                value = Email, onValueChange = { Email = it },
                label = { Text(text = "Email") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedLeadingIconColor = Color.Cyan,
                    focusedIndicatorColor = Color.Cyan,
                    unfocusedIndicatorColor = Color.Cyan
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide() // Hides the keyboard
                    }
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Username")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            OutlinedTextField(
                value = Username, onValueChange = { Username = it },
                label = { Text(text = "username") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedLeadingIconColor = Color.Cyan,
                    focusedIndicatorColor = Color.Cyan,
                    unfocusedIndicatorColor = Color.Cyan
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide() // Hides the keyboard
                    }
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = Password, onValueChange = { Password = it },
                shape = RoundedCornerShape(20.dp),
                label = { Text(text = "Password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedLeadingIconColor = Color.Cyan,
                    focusedIndicatorColor = Color.Cyan,
                    unfocusedIndicatorColor = Color.Cyan
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide() // Hides the keyboard
                    }
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )


            OutlinedTextField(
                value = ConfirmPassword, onValueChange = { ConfirmPassword = it },
                shape = RoundedCornerShape(20.dp),
                label = { Text(text = "Confirm password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.Cyan,
                    unfocusedLeadingIconColor = Color.Cyan,
                    focusedIndicatorColor = Color.Cyan,
                    unfocusedIndicatorColor = Color.Cyan
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Confirm Password"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide() // Hides the keyboard
                    }
                ),
                visualTransformation = PasswordVisualTransformation(),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Button(onClick = {
                if(Password == ConfirmPassword) {
                    authViewModel.signup(email = Email, password = Password)
                }
                else{
                    Toast.makeText(context,"Both Password Doesnt Match", Toast.LENGTH_SHORT).show()
                }
            },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.padding(top = 14.dp)

            ) {
                Text(text = "Create Account")
            }

            Text(text = "Already have any account ?", Modifier.padding(top = 10.dp))
            Text(text = "Login",
                Modifier
                    .clickable {
                        navController.navigate("login")
                    }
                    .padding(top = 2.dp))
        }
    }
}