package com.example.reply.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reply.ui.ui.theme.ReplyTheme
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class SignUp : ComponentActivity() {
    companion object {
        var globalVar=0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignupScreen(this)
                }
            }
        }
        Log.i("tttt","Creating client....")
        Client.create(applicationContext)
    }
}

@Composable
fun SignupScreen(context: Context) {
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
                 Toast.makeText(context," Please Enter Name", Toast.LENGTH_SHORT).show()
            }else if (userPhone.value.isEmpty()){
                Toast.makeText(context,"Enter Number", Toast.LENGTH_SHORT).show()
            }else if (userPassword.value.isEmpty()) {
                Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Validation Successfully Completed", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, Login::class.java))
            }

        },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "Save", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}







