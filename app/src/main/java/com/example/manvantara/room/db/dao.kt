package com.example.manvantara.room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface dao {

@Query("Select * from PPT")
fun getAllPpt() : LiveData<List<PPT>>

@Query("Select * from PDF")
fun getAllPdf() : LiveData<List<PDF>>
}