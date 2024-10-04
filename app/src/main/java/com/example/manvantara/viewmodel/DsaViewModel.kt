package com.example.manvantara.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manvantara.model.YoutubeVideo
import com.example.manvantara.repository.YoutubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DsaViewModel @Inject constructor(private val youtubeRepository: YoutubeRepository) : ViewModel() {
    private val _dsaplaylist = MutableLiveData<List<YoutubeVideo>>(emptyList())
    val dsaplaylist: LiveData<List<YoutubeVideo>>
        get() = _dsaplaylist

    init {
        _dsaplaylist.value = youtubeRepository.dsaPlaylist()
    }
}