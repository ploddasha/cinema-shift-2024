package com.ploddasha.cinemashiftapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ploddasha.cinemashiftapp.main.ui.MainScreen
import com.ploddasha.cinemashiftapp.ui.theme.CinemaShiftAppTheme

class MainActivity : ComponentActivity() {
    private val networkModule = NetworkModule()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaShiftAppTheme {
                MainScreen()
            }
        }
    }
}
