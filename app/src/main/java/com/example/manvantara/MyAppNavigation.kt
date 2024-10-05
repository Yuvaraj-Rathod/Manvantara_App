package com.example.manvantara

import LoginPage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.manvantara.screens.HomePage
import com.example.manvantara.screens.subject.OsPage
import com.example.manvantara.screens.SignUpPage
import com.example.manvantara.screens.other.CodeSnippetPage
import com.example.manvantara.screens.subject.CnPage
import com.example.manvantara.screens.subject.DbmsPage
import com.example.manvantara.screens.subject.DsaPage
import com.example.manvantara.viewmodel.AuthViewModel

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier) {
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = "Login") {
       composable("login") {
           LoginPage(modifier,navcontroller, authViewModel = AuthViewModel())
       }
        composable("homepage") {
            HomePage(modifier,navcontroller, authViewModel = AuthViewModel())
        }
        composable("signup") {
            SignUpPage(modifier,navcontroller, authViewModel = AuthViewModel())
        }
        composable("os") {
            OsPage(modifier,navcontroller)
        }
        composable("dbms") {
            DbmsPage(modifier,navcontroller)
        }
        composable("dsa") {
            DsaPage(modifier,navcontroller)
        }
        composable("cn") {
            CnPage(modifier,navcontroller)
        }
        composable("code snippet") {
            CodeSnippetPage(modifier)
        }
    }
}