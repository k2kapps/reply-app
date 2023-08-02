package com.example.appwritedemoapplication.ui.Database

import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reply.ui.Client.client
import com.example.reply.ui.Config
import io.appwrite.ID
import io.appwrite.Permission
import io.appwrite.Role
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.toJson
import io.appwrite.services.Databases
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import io.appwrite.Query

class DatabaseViewModel : ViewModel() {
    var s2 = ""
    /*
    private val _error = MutableLiveData<Event<AppwriteException>>().apply {
        value = null
    }
    val error: LiveData<Event<AppwriteException>> = _error

    private val _response = MutableLiveData<Event<String>>().apply {
        value = null
    }
    val response: LiveData<Event<String>> = _response
    */
    data class User(val name: String)
    /*
    private val _dialogText = MutableLiveData<String?>(null)
    val dialogText: LiveData<String?> = _dialogText*/

    val dialogText:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    val d2:MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    private val databaseService by lazy {
        Databases(client)
    }

    fun getd(id:String):String{
        val s1:String = "mydata"
        return s1
    }

    var tx1 by mutableStateOf("none")
        private set

    fun setval(){
        tx1 = "set new"
    }


    fun createDocument(content: Editable? , isComplete: Boolean) {
        val data = mapOf(
                "content" to content.toString(),
                "isComplete" to isComplete
        )
        val permissions = listOf(Permission.read(Role.any()))
        viewModelScope.launch {
            try {
                val response = databaseService.createDocument(Config.DATABASE, Config.COLLECTION, ID.unique(), data, permissions)
                val json = response.toJson()

               // _response.postValue(Event(json))
            } catch (e: AppwriteException) {
               // _error.postValue(Event(e))
            }
        }
    }

    fun getDocuments(s1:String) {
        viewModelScope.launch {
            try {
                val response = databaseService.listDocuments(Config.DATABASE, Config.COLLECTION)
                val json = response.toJson()
                //_response.postValue(Event(json))
            } catch (e: AppwriteException) {
                //_error.postValue(Event(e))
            }
        }
    }

    fun getDocument(id: Editable?) {
        viewModelScope.launch {
            try {
                val response = databaseService.getDocument(Config.DATABASE, Config.COLLECTION, id.toString())
                val json = response.toJson()
                //_response.postValue(Event(json))
            } catch (e: AppwriteException) {
                //_error.postValue(Event(e))
            }
        }
    }

    fun getDoc(id:String) {
        viewModelScope.launch {
            try {
                //val response = databaseService.getDocument(Config.DATABASE, Config.COLLECTION, id.toString())
                val response = databaseService.listDocuments(Config.DATABASE, Config.COLLECTION,
                    queries = listOf(Query.equal("destination","mumbai")),

                )

                /*val response=databaseService.listDocuments(
                    Config.DATABASE,
                    Config.COLLECTION,
                    queries = listOf(
                        Query.equal("origin", "pune")
                    )
                )*/

                val json = response.toJson()
                tx1 = response.documents.get(0).data.getValue("origin").toString()
                Log.i("oooooooo", response.documents.get(0).data.getValue("origin").toString())
                //tx1 = json.
            } catch (e: AppwriteException) {
                //_error.postValue(Event(e))
            }
        }
    }

    fun deleteDocument(id: Editable?) {
        viewModelScope.launch {
            try {
                val response = databaseService.deleteDocument(Config.DATABASE, Config.COLLECTION, id.toString())
                val json = response.toJson().ifEmpty { "{}" }
                //_response.postValue(Event(json))
            } catch (e: AppwriteException) {
               //_error.postValue(Event(e))
            }
        }
    }
}