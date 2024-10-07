package com.example.manvantara.screens.subject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.manvantara.R
import com.example.manvantara.model.CardData
import com.example.manvantara.screens.CardItem

object DisplayCardsObject {
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
                val intent= Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=J0OvDNmAWNw&pp=ygUQZHNhIG9uZSBzaG90IGMrKw%3D%3D")
                )
                context.startActivity(intent)
            },

            CardData(R.drawable.cn1, videoTitle = "Computer Networks", channelName = "KnowledgeGATE") {
                val intent= Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://youtu.be/q3Z3Qa1UNBA")
                )
                context.startActivity(intent)
            },

            CardData(
                R.drawable.dbms2, videoTitle = "Database Management System", channelName = "Code Help"
            ) {
                val intent= Intent(
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
}