package com.example.manvantara.utils

import android.annotation.SuppressLint
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object Constants {
    @SuppressLint("StaticFieldLeak")
    val remoteConfig = FirebaseRemoteConfig.getInstance()
    val apiKey: String
        get() = remoteConfig.getString("GEMINI_API")
}