package com.example.manvantara.screens.subject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.manvantara.viewmodel.OsViewModel

@Composable
fun OsPage(modifier: Modifier = Modifier,navController: NavController) {

    val osViewModel: OsViewModel = hiltViewModel()
    val osplaylist by osViewModel.osplaylist.observeAsState(emptyList())

    Column {
        // Top Section with Subject Name and Description
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                ) // Rounded bottom-left corner
                .background(Color(0XFF000000))  // Light cyan background
                .padding(16.dp)  // Padding inside the box
//                 .height(250.dp)
                .wrapContentHeight()

        ) {
            Column {
                Text(
                    text = "OPERATING SYSTEM",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Cyan,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 47.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Operating Systems (OS) manage hardware resources and software processes, providing an interface between users and computers." +
                            " It handles tasks like memory management, process scheduling, and device communication, " +
                            "enabling multi-tasking and ensuring efficient resource use. Popular OS examples include Windows, Linux, and macOS.",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
            items(osplaylist) { video ->
                PlayListItem(video = video)
            }
        }
    }
}