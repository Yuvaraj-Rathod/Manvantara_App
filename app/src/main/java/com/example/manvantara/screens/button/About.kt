package com.example.manvantara.screens.button

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.getValue
import com.example.manvantara.R
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation

import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
@Composable
fun About(modifier: Modifier = Modifier, navController: NavController) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.about))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever, speed = 1.2f )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Lottie animation for "About"
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(320.dp)
            )
            Spacer(modifier = Modifier.height(0.dp))
            // Heading for the About section
            Text(
                text = "About Manvantara",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Description of the Manvantara app
            Text(
                text = "Manvantara is a placement preparation app designed to help Computer Science students unlock their career potential. " +
                        "The app provides curated video playlists on various CS subjects such as DBMS, OS, and DSA, " +
                        "as well as aptitude PDFs and senior placement experience PPTs.",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Additional app features
            Text(
                text = "Key Features:",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // List of features
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "• Curated video playlists from top YouTubers.",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    text = "• Downloadable aptitude PDFs for topics like trains, boats, and time.",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    text = "• Senior placement experience PPTs.",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    text = "• Personalized profile management to track video progress.",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        }
    }
}
