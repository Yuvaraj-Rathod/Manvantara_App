package com.example.manvantara.screens.other

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.manvantara.screens.subject.PlayListItem
import com.example.manvantara.viewmodel.CnViewModel
import com.example.manvantara.viewmodel.CodeSnippetViewModel

@Composable
fun CodeSnippetPage(modifier: Modifier=Modifier){
        val codeSnippetViewModel : CodeSnippetViewModel = hiltViewModel()
        val codesnippetplaylist by codeSnippetViewModel.codesnippetplaylist.observeAsState(emptyList())

        LazyColumn(modifier=Modifier.padding(top = 30.dp)) {
            items(codesnippetplaylist){
                    video -> PlayListItem(video = video)

        }
    }
}