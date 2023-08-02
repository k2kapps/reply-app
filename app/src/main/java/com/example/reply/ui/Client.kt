package com.example.reply.ui

import android.content.Context
import android.util.Log
import io.appwrite.Client

object Client {
    lateinit var client : Client
    fun create(context: Context) {
        client = Client(context)
                .setEndpoint("https://cloud.appwrite.io/v1")
                .setProject("64b106551f99be65dcf5")
        Log.i("Tag","Client context created..........")

    }
}