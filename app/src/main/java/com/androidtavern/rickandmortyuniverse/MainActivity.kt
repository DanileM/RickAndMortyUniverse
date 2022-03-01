package com.androidtavern.rickandmortyuniverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.androidtavern.rickandmortyuniverse.presentation.ui.MainScreen
import com.androidtavern.rickandmortyuniverse.presentation.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(mainViewModel)
        }
    }
}