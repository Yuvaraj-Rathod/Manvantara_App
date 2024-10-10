package com.example.manvantara.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(context,(authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else -> Unit
        }


    }
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 90.dp, horizontal = 15.dp)
        ,
        verticalArrangement = Arrangement.Top,
        Alignment.CenterHorizontally,) {
//        Image(painter = painterResource(id =Icons.Default.AccountCircle), contentDescription = "guru")


    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 140.dp, horizontal = 26.dp)
        ,
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
                .padding(top = 5.dp))
    }
}