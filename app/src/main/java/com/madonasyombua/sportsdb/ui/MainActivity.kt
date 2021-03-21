package com.madonasyombua.sportsdb.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.madonasyombua.sportsdb.app.TheSportsApp
import com.madonasyombua.sportsdb.ui.screen.home.HomeViewModel
import com.madonasyombua.sportsdb.ui.screen.home.HomeScreen
import com.madonasyombua.sportsdb.ui.screen.teams.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TheSportsApp()
            }
        }
    }
}
