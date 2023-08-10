package com.example.reply

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reply.ui.ReplyAppContent
import com.example.reply.ui.ReplyHomeUIState

//@Composable
//fun ShowScreen(
//    replyHomeUIState: ReplyHomeUIState,
//    closeDetailScreen: () -> Unit = {},
//    navigateToDetail: (Long) -> Unit = {},
//    modifier: Modifier
//) {
//    ReplyAppContent(
//        replyHomeUIState = replyHomeUIState,
//        closeDetailScreen = closeDetailScreen,
//        navigateToDetail = navigateToDetail
//    )
//}

@Composable
fun SecondScreen(modifier: Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)
        .padding(vertical = 80.dp)
    ) {
        var text by remember { mutableStateOf("type here...") }

        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = {
                Text(text = "Origin",
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold)

            }
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp)
            .padding(vertical = 30.dp)
        ) {
            var text by remember { mutableStateOf("type here...") }

            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = {
                    Text(text = "Destination",
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold)

                })
        }
    }
}
/* leadingIcon = {
                IconButton(onClick = {  }) {
                    Icons(ImageVector = Icons.Filled.Email,
                        contentDescription ="Email Icon"
                    )
                }
            } */
