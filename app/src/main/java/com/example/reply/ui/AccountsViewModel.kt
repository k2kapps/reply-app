package com.example.reply.ui

import android.text.Editable
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reply.ui.Login.Companion.globalVar
import com.example.reply.ui.Client.client
import io.appwrite.ID
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.toJson
import io.appwrite.services.Account
import kotlinx.coroutines.launch
import java.util.logging.Logger.global

class AccountsViewModel : ViewModel() {

    private val accountService by lazy {
        Account(client)
    }
    val account = Account(client)



    fun onSignup(email: String , password : String, name: String, d1:Int): Int {
        var loginstatus=0
        viewModelScope.launch {
           try {
                val response = accountService.create(ID.unique(), email.toString(), password.toString(), name.toString())
                val json = response.toJson()
                Log.i("tag",response.toString())
                loginstatus = 1
            } catch (e: AppwriteException) {
               // _error.postValue(Event(e))
                Log.i("error",e.message.toString());
                loginstatus = 2
            }
        }
        println("Int...$loginstatus");
        return loginstatus
    }

    fun onLogin(email: String, password : String) {
        viewModelScope.launch {
            try {
                val response = accountService.createEmailSession(email.toString(), password.toString())
                val json = response.toJson()
                Log.i("tag",response.toString())
            } catch (e: AppwriteException) {
                Log.i("error",e.message.toString())
            }
        }

    }

}


