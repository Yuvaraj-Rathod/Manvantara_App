package com.example.manvantara.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.manvantara.screens.subject.DisplayCardsObject
import com.example.manvantara.viewmodel.AuthState
import com.example.manvantara.viewmodel.AuthViewModel
import kotlin.math.roundToInt

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
                    .padding(start = 12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TopBar(navController = navController,authViewModel =authViewModel)

                Spacer(modifier = Modifier.height(4.dp)) // Space between title and search bar

                // Search Bar
                SearchBar(navController = navController)

                // Course Videos Section
                Text(
                    text = "Course Videos",
                    color = Color(0xFFB2FFFF),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )

//                Spacer(modifier = Modifier.height(6.dp))

                    DisplayCardsObject.DisplaySubjectCards(navController)

//                Spacer(modifier = Modifier.height(6.dp))

                // One shot videos Section
                Text(
                    text = "One shot videos",
                    color = Color(0xFFB2FFFF),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                    DisplayCardsObject.DisplayOneShotCards(navController)

//                Spacer(modifier = Modifier.height(6.dp))

                // Aptitude Section
                Text(
                    text = "Aptitude",
                    color = Color(0xFFB2FFFF),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                DisplayCardsObject.DisplayOtherCards(navController)
//                DraggableFloatingButton(imageVector = Icons.Default.Favorite, description = "download") {}
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
        shape = RoundedCornerShape(20.dp),
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
            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp, end = 16.dp),
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

@Composable
fun TopBar(navController: NavController,authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 14.dp, top = 25.dp, end = 14.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {

            BoxButton(imageVector = Icons.Default.Info, description = "about") {
                navController.navigate("about")
            }

            Text(text = "Manvantara",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp)
            )

            BoxButton(imageVector = Icons.Default.Person, description = "profile") {
                navController.navigate("profile")
            }

            BoxButton(imageVector = Icons.Default.ExitToApp, description = "exit") {
                authViewModel.signout()
            }
        }
    }
}

@Composable
fun BoxButton(imageVector: ImageVector, description: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp)) // Apply rounded corners here
            .background(Color(0xFF008B8B)) // Apply the background color to the Box
            .clickable(onClick = onClick) // Handle click events
            .padding(8.dp), // Padding inside the box
        contentAlignment = Alignment.Center // Centers the content within the Box
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = description,
            tint = Color.White,
            modifier = Modifier.size(25.dp) // Adjust the size of the icon
        )
    }
}

//@Composable
//fun DraggableFloatingButton(
//    imageVector: ImageVector, // Button icon
//    description: String, // Content description
//    onClick: () -> Unit // Click action
//) {
//    // Remember the position state
//    var offsetX by remember { mutableStateOf(0f) }
//    var offsetY by remember { mutableStateOf(0f) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize() // Fill the available space
//    ) {
//        Box(
//            modifier = Modifier
//                .size(56.dp) // Size of the button
//                .clip(CircleShape) // Circular shape for the button
//                .background(Color(0xFF008B8B)) // Background color
//                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) } // Offset for drag movement
//                .pointerInput(Unit) {
//                    detectDragGestures { change, dragAmount ->
//                        change.consume() // Consume the gesture
//                        // Update the offset based on the drag amount
//                        offsetX += dragAmount.x
//                        offsetY += dragAmount.y
//                    }
//                }
//                .clickable(onClick = onClick) // Handle clicks
//        ) {
//            Icon(
//                imageVector = imageVector,
//                contentDescription = description,
//                tint = Color.White,
//                modifier = Modifier
//                    .align(Alignment.Center) // Center the icon inside the box
//                    .size(30.dp) // Size of the icon inside the button
//            )
//        }
//    }
//}
