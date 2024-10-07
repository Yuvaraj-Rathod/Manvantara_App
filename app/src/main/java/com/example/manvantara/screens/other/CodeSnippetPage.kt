package com.example.manvantara.screens.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.manvantara.screens.subject.PlayListItem
import com.example.manvantara.viewmodel.CnViewModel
import com.example.manvantara.viewmodel.CodeSnippetViewModel

@Composable
fun CodeSnippetPage(modifier: Modifier=Modifier) {
    val codeSnippetViewModel: CodeSnippetViewModel = hiltViewModel()
    val codesnippetplaylist by codeSnippetViewModel.codesnippetplaylist.observeAsState(emptyList())

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
                .height(250.dp)

        ) {
            Column {
                Text(
                    text = "GUESS THE OUTPUT",
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
                    text = "Guess the Output is a popular exercise in programming, where learners are given a code snippet and asked to predict the result of its execution." +
                            " This technique enhances critical thinking and deepens understanding of programming concepts like loops, " +
                            "conditionals, and data types by challenging one's comprehension of code behavior.",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
            items(codesnippetplaylist) { video ->
                PlayListItem(video = video)

            }
        }
    }
}