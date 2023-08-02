package com.example.reply.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reply.ui.AccountsViewModel
import com.example.reply.ui.Client
import com.example.reply.ui.ui.theme.ReplyTheme
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import com.example.reply.ui.Client.client

private lateinit var viewModel: AccountsViewModel
var text1: String by mutableStateOf("")
class Login : ComponentActivity() {
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
                    Greeting("Android")
                }
            }
        }
        Log.i("tttt","Creating client....")
        Client.create(applicationContext)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(value:String) {

    Column(modifier = Modifier.padding(16.dp)){
        //DateSelect()
        //Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Welcome,", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Sign in to continue,", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(110.dp))
        RegisterEmail()
        Spacer(modifier = Modifier.height(10.dp))
        RegisterPassword()
    }
}

class TextFieldState(){
    var text: String by mutableStateOf("")
}

@ExperimentalMaterial3Api
@Composable
fun DateSelect(){
        // Pre-select a date for January 4, 2020
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
        DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))
}

@Composable
fun RegisterEmail() {
    //val keyboardController = LocalSoftwareKeyboardController.current
    //var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text1,
        onValueChange = { text1 = it },
        shape = RoundedCornerShape(topEnd =8.dp, topStart =8.dp, bottomStart =8.dp, bottomEnd =8.dp),
        label = {
            Text(
                "Email Address",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium,
            ) },
        placeholder = { Text(text = "Email Address") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                //keyboardController?.hide()
                // do something here
            }
        )
    )

}


@Composable
fun RegisterPassword(emailState : TextFieldState = remember { TextFieldState() }) {
    //val keyboardController = LocalSoftwareKeyboardController.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    val context = LocalContext.current
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        shape = RoundedCornerShape(topEnd =8.dp, topStart =8.dp, bottomStart =8.dp, bottomEnd =8.dp),
        label = {
            Text(
                "Enter Password",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium,
            ) },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        ),

        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                //keyboardController?.hide()
                // do something here
            }
        )
    )

    Button(onClick = {
        //your onclick code here
        viewModel = AccountsViewModel()
        var data:Int=0
        var n1= viewModel.onLogin(text1, password)
        //Log.i("data",text1+"----"+password)
        /*
        if (n1==2){
            Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show()
        }
        if (n1==1){
            Toast.makeText(context, "Succuss...", Toast.LENGTH_SHORT).show()
        }*/
        context.startActivity(Intent(context, MainActivity::class.java))
    }) {
        Text(text = "Simple Button")
    }


}





