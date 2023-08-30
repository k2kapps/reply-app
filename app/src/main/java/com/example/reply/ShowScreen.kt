package com.example.reply

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import java.util.*

@Composable
fun Textfield1(closeDetailScreen: () -> Unit, navigateToDetail: (Long) -> Unit, modifier: Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)
        .padding(vertical = 90.dp)
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
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .fillMaxSize()
            //.padding(horizontal = 20.dp)
            //.padding(vertical = 160.dp)
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
            Spacer(modifier = Modifier.height(20.dp))
            Droplist1()
           Spacer(modifier = Modifier.height(10.dp))
            Droplist2()

        }
    }
}
@Composable
fun Droplist1() {

    var expanded by remember { mutableStateOf(false) }
    val list = listOf("java", "kotlin", "c++", "js", "Sql", "php", "Android", "Studio", "etc")
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier
        //  .padding(vertical = 0.dp)
        //.padding(horizontal = 0.dp)
    ) {

        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {
                Text(text = "Tonague",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal)
            },
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })

        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    //Text(text = label)
                }
            }
        }
    }
}

 fun DropdownMenuItem(onClick: () -> Unit, interactionSource: () -> Unit) {

}

@Composable
fun Droplist2(){

    var expanded by remember { mutableStateOf(false) }
    val list = listOf("A","B","C","D","E","F","G","H","etc")
    var selectedItem by remember{ mutableStateOf("") }

    var textFieldSize by remember{ mutableStateOf(Size.Zero) }

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier
       // .padding(vertical = 20.dp)
    //    .padding(horizontal = 0.dp)
    ) {
        OutlinedTextField(
            value = selectedItem ,
            onValueChange = { selectedItem = it},
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Goods List",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold) },
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded =expanded ,
            onDismissRequest = { expanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current){textFieldSize.width.toDp()})
        ) {
            list.forEach { label->
                DropdownMenuItem(onClick = {selectedItem = label
                    expanded = false
                }) {
                   // Text(text = label)

                }
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()
        .padding(20.dp),
    verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
        Button(onClick = {})
        {
          Text(text = "Save",modifier = Modifier.fillMaxWidth(0.6f),
              fontSize = 20.sp, textAlign = TextAlign.Center)
        }

    }
}



//fun OutlinedTextField(
//    value: String,
//    onValueChange: () -> Unit,
//    modifier: Modifier,
//    label: () -> Unit
//) {
//
//}







/* leadingIcon = {
                IconButton(onClick = {  }) {
                    Icons(ImageVector = Icons.Filled.Email,
                        contentDescription ="Email Icon"
                    )
                }
            } */
