package com.example.manvantara.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PPT(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val url : String,
    val isDownloaded : Boolean
)

@Entity
data class PDF(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val url : String,
    val isDownloaded : Boolean
)