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

package com.example.reply.ui.components

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appwritedemoapplication.ui.Database.DatabaseViewModel
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.ui.Client
import com.example.reply.ui.Config
import com.example.reply.ui.MainActivity
import com.example.reply.ui.ReplyHomeViewModel
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.toJson
import io.appwrite.services.Databases
import kotlinx.coroutines.launch

data class user(val name: String, val age: Int)

@Composable
fun ReplyEmailListItem(
    email: Email,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    val vm = viewModel<DatabaseViewModel>()
    val context = LocalContext.current
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .semantics { selected = isSelected }
        //.clickable { navigateToDetail(email.id) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ReplyProfileImage(
                    drawableResource = email.sender.avatar,
                    description = email.sender.fullName,
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = email.sender.firstName,
                    )
                    Text(
                        text = email.createdAt,
                    )
                    //vm.getDoc("64b8adeb6aa220fa2a16")
                    //Log.i("getting",vm.dialogText.value.toString())
                    Text(
                        text = vm.tx1
                        //text="node"
                    )
                }
                Button(onClick = { vm.setval() }) {
                    Text(text = "Button")
                }
                /*

                IconButton(
                    onClick = { Toast.makeText(context, "Succuss...", Toast.LENGTH_SHORT).show() },
                    modifier = Modifier
                        .clip(CircleShape)

                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = stringResource(id = R.string.description_favorite),
                    )
                }*/
            }

            Text(
                text = email.subject,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            )
            Text(
                text = email.body,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


