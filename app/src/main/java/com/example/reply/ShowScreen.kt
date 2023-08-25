package com.example.reply

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun RegisterScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var userName = remember { mutableStateOf("") }
        var userEmail = remember { mutableStateOf("") }
        var userPhone = remember { mutableStateOf("") }
        var userAddress = remember { mutableStateOf("") }
        var userPassword = remember { mutableStateOf("") }
        var userConfirmPassword = remember { mutableStateOf("") }

        Text(
            text = "Sign Up", fontSize =35.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))

           OutlinedTextField(value = userName.value,
               onValueChange ={userName.value = it},
               label = { Text(text = "Name") },
               placeholder = { Text(text = "Your Name") },
               singleLine = true,
               modifier = Modifier.fillMaxWidth(0.8f)
               )
               Spacer(modifier = Modifier.height(10.dp))

           OutlinedTextField(
               value = userEmail.value,
               onValueChange = { userEmail.value = it },
               label = { Text(text = "Email") },
               placeholder = { Text(text = "email@gmail.com") },
               singleLine = true,
               modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userPhone.value,
            onValueChange = { userPhone.value = it },
            label = { Text(text = "Phone") },
            placeholder = { Text(text = "1234567890") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userAddress.value,
            onValueChange = { userAddress.value = it },
            label = { Text(text = "Address") },
            placeholder = { Text(text = "Type your address") },
            singleLine = false,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.3f),
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userPassword.value,
            onValueChange = { userPassword.value = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userConfirmPassword.value,
            onValueChange = { userConfirmPassword.value = it },
            label = { Text(text = "Confirm/Password") },
            placeholder = { Text(text = "") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (userName.value.isEmpty()){
                // Toast.makeText(context," Please Enter Name", Toast.LENGTH_SHORT).show()
            }else if (userPhone.value.isEmpty()){
                //Toast.makeText(context,"Enter Number", Toast.LENGTH_SHORT).show()
            }else if (userPassword.value.isEmpty()) {
                //Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
            }else{
                //Toast.makeText(context,"Validation Successfully Completed", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "Save", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun Textfield1() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)
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
                   // Text(text = label)
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
                  //  Text(text = label)

                }
            }
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
