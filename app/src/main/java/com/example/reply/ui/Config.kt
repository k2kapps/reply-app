package com.example.reply.ui

/**
 * Config file for the Appwrite demo application
 */
object Config {

    // Change below values to match your Appwrite project
    const val HOST = "https://cloud.appwrite.io/v1"
    const val PROJECT = "64b106551f99be65dcf5"
    const val DATABASE = "64b4260506f0b6c083c2"
    const val COLLECTION = "64b816f75cb5c44c53cf"
    const val STORAGE = "[BUCKET]"

    // DO NOT mutate below values
    const val ENDPOINT = "https://$HOST/v1"
    const val CALLBACK = "appwrite-callback-$PROJECT"
}