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
import com.madonasyombua.sportsdb.ui.screen.home.HomeViewModel
import com.madonasyombua.sportsdb.ui.screen.home.HomeScreen
import com.madonasyombua.sportsdb.ui.screen.teams.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()
    private val teamsViewModel:TeamsViewModel by viewModels()
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                MyApp(viewModel,teamsViewModel = teamsViewModel)
            }
        }

    }

}

@ExperimentalFoundationApi
@Composable
fun MyApp(viewModel: HomeViewModel,teamsViewModel: TeamsViewModel) {
    HomeScreen(viewModel,teamsViewModel = teamsViewModel)

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MaterialTheme {
        // MyApp()
    }
}
