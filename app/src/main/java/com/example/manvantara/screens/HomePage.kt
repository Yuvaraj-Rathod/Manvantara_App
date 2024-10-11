package com.example.manvantara.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.manvantara.screens.subject.DisplayCardsObject
import com.example.manvantara.viewmodel.AuthState
import com.example.manvantara.viewmodel.AuthViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val searchQuery = remember { mutableStateOf("") }
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current.applicationContext

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(start = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(16.dp)) // Space between title and search bar

                // Search Bar
                SearchBar(navController = navController)

                Spacer(modifier = Modifier.height(12.dp))

                // Course Videos Section
                Text(
                    text = "Course Videos",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                    DisplayCardsObject.DisplaySubjectCards(navController)

                Spacer(modifier = Modifier.height(8.dp))

                // One shot videos Section
                Text(
                    text = "One shot videos",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                    DisplayCardsObject.DisplayOneShotCards(navController)

                Spacer(modifier = Modifier.height(8.dp))

                // Aptitude Section
                Text(
                    text = "Aptitude",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                DisplayCardsObject.DisplayOtherCards(navController)

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                        .padding(bottom = 15.dp),
                        //.background(Color(0XFF000000)),
                    // Fills the parent size
                    contentAlignment = Alignment.Center// Centers the content within the Box
                    ) {
                    IconButton(onClick = { authViewModel.signout() }){
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "Sign out",
                            tint = Color.White,
                            modifier = Modifier.size(78.dp)
                                .background(Color(0XFF00FFFF)))
                    }
                }
            }
        }
    )
}


@Composable
fun GlowingIcon(icon: ImageVector, description: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = Color.Cyan,
            modifier = Modifier
                .size(20.dp)
                .shadow(15.dp, shape = CircleShape) // Glowing effect
                .background(Color.Transparent)
        )
        Text(
            text = description,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        label = { Text(text = "Search Course") },
        shape = RoundedCornerShape(35.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Cyan,
            unfocusedBorderColor = Color.Cyan,
            cursorColor = Color.Cyan,
            focusedLabelColor = Color.Cyan,
            unfocusedLabelColor = Color.White,
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            handleSearchQuery(navController, searchQuery)
        })
    )
}

fun handleSearchQuery(navController: NavController, query: String) {
    when (query.lowercase()) {
        "os", "operating system" -> navController.navigate("os")
        "dbms" -> navController.navigate("dbms")
        "dsa" -> navController.navigate("dsa")
        "cn", "computer networks" -> navController.navigate("cn")

        else -> {
            // Optionally show a Toast or Snackbar to notify the user about invalid search input
        }
    }
}
