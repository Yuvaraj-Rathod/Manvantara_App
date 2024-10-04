package com.example.manvantara.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manvantara.model.YoutubeVideo
import com.example.manvantara.repository.YoutubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OsViewModel @Inject constructor(private val youtubeRepository: YoutubeRepository) : ViewModel(){

    private val _osplaylist = MutableLiveData<List<YoutubeVideo>>(emptyList())
    val osplaylist: LiveData<List<YoutubeVideo>>
        get() = _osplaylist

    init {
        _osplaylist.value  = youtubeRepository.OsPlaylist()
    }
}