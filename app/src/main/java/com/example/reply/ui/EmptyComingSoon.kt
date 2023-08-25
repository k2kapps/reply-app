/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.reply.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reply.R

@Composable
fun EmptyComingSoon(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(horizontal = 10.dp)
            .padding(vertical = 80.dp),
       // verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {  var text by remember { mutableStateOf("type here...") }
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = {
                Text(text = "Origin",
                    color = Color.Blue,
                    fontSize = 21.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold)

            }
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp)
            .padding(vertical = 20.dp)
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
//        Text(
//            modifier = Modifier.padding(8.dp),
//            text = stringResource(id = R.string.empty_screen_title),
//            style = MaterialTheme.typography.titleLarge,
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.primary
//        )
//        Text(
//            modifier = Modifier.padding(horizontal = 8.dp),
//            text = stringResource(id = R.string.empty_screen_title),
//            style = MaterialTheme.typography.bodySmall,
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.outline
//        )
    }

@Preview
@Composable
fun ComingSoonPreview() {
    EmptyComingSoon()
}