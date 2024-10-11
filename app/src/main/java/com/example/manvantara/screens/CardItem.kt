package com.example.manvantara.screens
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manvantara.model.CardData
import com.example.manvantara.R


@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun CardItem(cardData: CardData) {
    Card(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 8.dp) // Increased padding for better card spacing
            .width(330.dp) // Increased width for a more prominent card
            .shadow(10.dp, RoundedCornerShape(12.dp)) // Increased shadow and rounded corners for depth
            .background(Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Column(
            Modifier.background(Color.Black)
        ) {
            Image(
                painter = painterResource(id = cardData.thumbnail),
                contentDescription = "thumbnail",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .shadow(6.dp, shape = RoundedCornerShape(10.dp)), // Rounded image for a softer look
                contentScale = ContentScale.Crop
            )

            Box(Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                ) {
                    Text(
                        text = cardData.videoTitle,
                        color = Color.Cyan,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp // Increased title font size
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = cardData.channelName,
                        maxLines = 1,
                        fontSize = 14.sp,
                        color = Color.LightGray // Lighter color for contrast
                    )
                }

                IconButton(
                    onClick = { cardData.onClick() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 20.dp, end = 10.dp) // Adjusted padding for icon
                        .size(42.dp) // Slightly larger icon button
                        .shadow(10.dp, shape = CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tributton),
                        contentDescription = "button",
                        colorFilter = ColorFilter.tint(Color.Cyan),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
