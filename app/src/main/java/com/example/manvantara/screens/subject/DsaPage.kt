package com.example.manvantara.screens.subject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.manvantara.viewmodel.DbmsViewModel
import com.example.manvantara.viewmodel.DsaViewModel

@Composable
fun DsaPage(modifier: Modifier = Modifier, navController: NavController) {
    val dsaViewModel : DsaViewModel = hiltViewModel()
    val dsaplaylist by dsaViewModel.dsaplaylist.observeAsState(emptyList())

    LazyColumn(modifier=Modifier.padding(top = 30.dp)) {
        items(dsaplaylist){
                video -> PlayListItem(video = video)
        }
    }
}