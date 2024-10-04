package com.example.manvantara.screens.subject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.manvantara.model.YoutubeVideo
import com.example.manvantara.R


@Composable
fun PlayListItem(video : YoutubeVideo) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.Cyan
        ),  // Cyan theme for the card
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            // Topic Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = video.title,
                    fontSize = 13.sp,
                    color = Color.Cyan,  // White text for contrast
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal
                )

                // Expand/Collapse Icon
                IconButton(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(video.link)
                    )
                    context.startActivity(intent)
                }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Video",
                        tint = Color.Cyan
                    )
                }
            }
        }
    }
}