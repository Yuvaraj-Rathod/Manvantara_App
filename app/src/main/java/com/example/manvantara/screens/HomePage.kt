package com.example.manvantara.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.manvantara.R
import com.example.manvantara.model.CardData
import com.example.manvantara.viewmodel.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current.applicationContext
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Man",
                            color = Color.White,
//                            style = MaterialTheme.typography.headlineLarge // Adjust the text style if needed
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif, // Use a clean, modern font
                            fontStyle = FontStyle.Normal,
                            fontSize = 25.sp


                        )
                        Text(
                            text = "vantara",
                            color = Color.Cyan,
                            fontWeight = FontWeight.Bold,
//                            style = MaterialTheme.typography.headlineSmall // Adjust the text style if needed
                            fontFamily = FontFamily.SansSerif, // Use a clean, modern font
                            fontStyle = FontStyle.Normal,
                            fontSize = 25.sp
                        )
                    }
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.jobgenielogo),
                        contentDescription = "JobGenie",
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp)
                            .padding(start = 10.dp, top = 8.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                actions = {
                    IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
                    }
                    IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show() }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    }
                    IconButton(onClick = { Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show() }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
                    }
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .padding(it)// Adjusted padding for a more balanced layout
        ) {
                DisplaySubjectCards(navController)
        }
    }
}

@Composable
fun DisplaySubjectCards(navController: NavController) {
    val videoList = listOf(
        CardData(R.drawable.os, videoTitle = "Operating System ", channelName = "Love Babbar"){
            navController.navigate("os")
        },
        CardData(R.drawable.dbms, videoTitle = "Database management System ", channelName = "Gate Smashers"){
            navController.navigate("dbms")
        },
        CardData(R.drawable.dsa, videoTitle = "Data Structures and Algorithm  ", channelName = "Geeks For Geeks"){
            navController.navigate("dsa")
        },
        CardData(R.drawable.cn, videoTitle = "Computer Networks", channelName = "Gate Smashers"){
            navController.navigate("cn")
        }
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videoList) { video ->
            CardItem(cardData = video)
        }
    }
}
