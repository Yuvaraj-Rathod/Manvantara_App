package com.example.manvantara.screens.subject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.manvantara.model.YoutubeVideo
import com.example.manvantara.repository.YoutubeRepository
import com.example.manvantara.viewmodel.DbmsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun DbmsPage(modifier: Modifier = Modifier, navController: NavController) {
    val dbmsViewModel: DbmsViewModel = hiltViewModel()
    val dbmsPlaylist by dbmsViewModel.dbmsplaylist.observeAsState(emptyList())

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
                //                .height(250.dp)
                .wrapContentHeight()

        ) {
            Column {
                Text(
                    text = "DATABASE MANAGEMENT",
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
                    text = "A Database Management System (DBMS) enables the storage, retrieval, and management of structured data in an organized manner. " +
                            "It ensures data integrity, security, and efficient access. " +
                            "Common DBMS examples include MySQL, Oracle, and PostgreSQL, essential for managing large datasets across various applications.",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // LazyColumn for the playlist items
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(dbmsPlaylist) { video ->
                PlayListItem(video = video)
            }
        }
    }
}
