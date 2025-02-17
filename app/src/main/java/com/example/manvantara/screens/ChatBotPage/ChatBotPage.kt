package com.example.manvantara.screens.ChatBotPage

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manvantara.model.MessageModel
import com.example.manvantara.ui.theme.modelColor
import com.example.manvantara.ui.theme.userColor
import com.example.manvantara.viewmodel.ChatViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(modifier: Modifier = Modifier, chatViewModel: ChatViewModel) {

    val message = remember { mutableStateOf("") }

    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Box(
//                        modifier = Modifier.fillMaxWidth(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "QnY",
//                            style = TextStyle(
//                                fontSize = 30.sp, // Set a larger font size
//                                fontWeight = FontWeight.Bold, // Optional: Make it bold
//                                color = Color(0xFF512D6D) // Darker color
//                            ),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.smallTopAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primary
//                )
//            )
//        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                MessageInput(onMessageSend = {
                    chatViewModel.sendMessage(it)
                })
            }
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Message list
                    MessageList(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        messageList = chatViewModel.messageList
                    )

//                     Placeholder text when no messages
                    if (chatViewModel.messageList.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
                            contentAlignment = Alignment.Center
                        ) {
                            SelectionContainer {
                                Text(
                                    text = "Start chatting with QnY!",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }

                        }
                    }
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInput(modifier: Modifier = Modifier,onMessageSend : (String) -> Unit) {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = message,
            onValueChange = { message = it },
            placeholder = { Text("Ask a question...") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            singleLine = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = {
            if(message.isNotEmpty()){
                onMessageSend(message.toString())
                println("User asked: ${message}")
                message = "" // Clear the input after sending
            }}) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun MessageList(modifier: Modifier = Modifier,messageList : List<MessageModel>) {
    LazyColumn (modifier = modifier, reverseLayout = true){
        items(messageList.reversed()){
            MessageRow(messagemodel = it)
        }
    }
}

@Composable
fun MessageRow(messagemodel : MessageModel) {
    val isModel = messagemodel.role == "model"
    Row (verticalAlignment = Alignment.CenterVertically)
    {
        Box(modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier.align(if(isModel) Alignment.BottomStart else Alignment.BottomEnd)
                .padding(
                    start = if(isModel) 8.dp else 70.dp,
                    end = if(isModel) 70.dp else 8.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .clip(RoundedCornerShape(48f))
                .background(if(isModel) modelColor else userColor)
                .padding(16.dp)
            ) {
                SelectionContainer {
                    Text(text = messagemodel.message,
                        fontWeight = FontWeight.W500)
                }

            }

        }
    }
}



@Preview
@Composable
private fun ChatScreenPreview() {
    val chatViewModel = ChatViewModel()
    ChatScreen(modifier = Modifier.padding(10.dp),chatViewModel)
}