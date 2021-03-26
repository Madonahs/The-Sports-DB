package com.madonasyombua.sportsdb.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.madonasyombua.sportsdb.app.TheSportsApp
import com.madonasyombua.sportsdb.ui.theme.SportsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkTheme = remember { mutableStateOf(false) }
            SportsAppTheme(darkTheme = darkTheme.value) {
                TheSportsApp {
                    darkTheme.value = !darkTheme.value
                    Timber.d("theme ${darkTheme.value}")
                }
            }

        }
    }
}
