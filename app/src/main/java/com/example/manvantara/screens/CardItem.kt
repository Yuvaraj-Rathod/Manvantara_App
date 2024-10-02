package com.example.manvantara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manvantara.model.CardData
import com.example.manvantara.R

@Composable
fun CardItem(cardData: CardData) {
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 10.dp)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)){

        Column(Modifier.background(Color.Black)) {
            Image(
                painter = painterResource(id = cardData.thumbnail),
                contentDescription = "thumbnail",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )

            Box(Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .align(Alignment.TopStart)
                        .padding(18.dp)
                ) {
                    Text(
                        text = cardData.videoTitle,
                        color = Color.Cyan,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = cardData.channelName,
                        maxLines = 1,
                        fontSize = 12.sp,
                        color = Color.Cyan
                    )
                }

                IconButton(
                    onClick = { cardData.onClick() },
                    modifier = Modifier.align(Alignment.TopEnd).
                    padding(top = 20.dp, end = 5.dp)
                        .size(40.dp)
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


@Preview
@Composable
private fun PreviewCard() {
    CardItem(cardData = CardData(R.drawable.dbms,"Operating System","Love Babbar"){})
}