package com.madonasyombua.sportsdb.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import com.madonasyombua.sportsdb.app.App
import com.madonasyombua.sportsdb.app.TheSportsApp
import com.madonasyombua.sportsdb.ui.theme.SportsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var app:App
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsAppTheme(darkTheme = app.isDark.value) {
                TheSportsApp(app)
            }
        }
    }
}
