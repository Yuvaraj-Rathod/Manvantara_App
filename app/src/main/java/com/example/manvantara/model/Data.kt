package com.example.manvantara.model

import androidx.annotation.DrawableRes

data class CardData(
    @DrawableRes val thumbnail : Int,
    val videoTitle : String,
    val channelName : String,
    val onClick : () -> Unit)
