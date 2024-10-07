package com.example.manvantara.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.manvantara.R
import com.example.manvantara.model.CardData
import com.example.manvantara.viewmodel.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val searchQuery = remember { mutableStateOf("") } // State to handle the search query

    Scaffold() {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp) // Adjust padding for balance
                .verticalScroll(rememberScrollState()) // Add the scroll state
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Align text and icon properly
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Man",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold, // Enhanced font weight for title
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 42.sp, // Slightly larger font for emphasis
                        modifier = Modifier.shadow(8.dp, shape = RoundedCornerShape(8.dp))
                    )
                    Text(
                        text = "vantara",
                        color = Color.Cyan,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 38.sp, // Increased font size to match "Man"
                        modifier = Modifier.shadow(5.dp, shape = RoundedCornerShape(8.dp))
                    )
                }

                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Account Icon",
                    tint = Color.Cyan,
                    modifier = Modifier
                        .size(35.dp) // Slightly increased size for icon
                        .padding(end = 8.dp) // Added padding on the right
                )
            }

            Spacer(modifier = Modifier.height(16.dp)) // Space between title and search bar

            // Search Bar using OutlinedTextField
            SearchBar(navController = navController)

            Spacer(modifier = Modifier.height(12.dp)) // Space between search bar and description

            Column(
//                modifier = Modifier.padding(top = 0.dp)
            ) {

                Text(
                    text = "Course Videos",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp, // Increased size for section title
                    modifier = Modifier.padding(start = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp)) // Spacer between section title and cards

                DisplaySubjectCards(navController)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "One shot videos",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp, // Increased size for section title
                    modifier = Modifier.padding(start = 16.dp)
                )
                DisplayOneShotCards(navController)

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = "Aptitude",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 24.sp, // Increased size for section title
                    modifier = Modifier.padding(start = 16.dp)
                )
                DisplayOtherCards(navController)
            }
        }
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

@Composable
fun DisplaySubjectCards(navController: NavController) {
    val videoList = listOf(
        CardData(R.drawable.os, videoTitle = "Operating System", channelName = "Love Babbar") {
            navController.navigate("os")
        },
        CardData(R.drawable.dbms, videoTitle = "Database Management System", channelName = "Code Help") {
            navController.navigate("dbms")
        },
        CardData(R.drawable.dsa, videoTitle = "Data Structures and Algorithm", channelName = "Apna College") {
            navController.navigate("dsa")
        },
        CardData(R.drawable.cn, videoTitle = "Computer Networks", channelName = "KnowledgeGATE") {
            navController.navigate("cn")
        }
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Adjust horizontal spacing between items
    ) {
        items(videoList) { video ->
            CardItem(cardData = video)
        }
    }
}

@Composable
fun DisplayOneShotCards(navController: NavController) {
    val context = LocalContext.current
    val videoList = listOf(


        CardData(R.drawable.s1, videoTitle = "Operating System", channelName = "Love Babbar") {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=3obEP8eLsCw&pp=ygUSY29kZSBoZWxwIG9uZSBzaG90")
            )
            context.startActivity(intent)
        },

        CardData(
            R.drawable.dsa2, videoTitle = "Data Structures and Algorithm", channelName = "Apna College"
        ) {
            val intent=Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=J0OvDNmAWNw&pp=ygUQZHNhIG9uZSBzaG90IGMrKw%3D%3D")
            )
            context.startActivity(intent)
        },

        CardData(R.drawable.cn1, videoTitle = "Computer Networks", channelName = "KnowledgeGATE") {
            val intent=Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/q3Z3Qa1UNBA")
            )
            context.startActivity(intent)
        },

        CardData(
            R.drawable.dbms2, videoTitle = "Database Management System", channelName = "Code Help"
        ) {
            val intent=Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=dl00fOOYLOM&pp=ygUXY29kZSBoZWxwIG9uZSBzaG90IGRibXM%3D")
            )
            context.startActivity(intent)
        }

    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Adjust horizontal spacing between items
    ) {
        items(videoList) { video ->
            CardItem(cardData = video)
        }
    }
}

@Composable
fun DisplayOtherCards(navController: NavController) {
    val videoList = listOf(
        CardData(R.drawable.codesnippet, videoTitle = "Guess the Output", channelName = "Geeks For Geeks") {
            navController.navigate("code snippet")
        }
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Adjust horizontal spacing between items
    ) {
        items(videoList) { video ->
            CardItem(cardData = video)
        }
    }
}