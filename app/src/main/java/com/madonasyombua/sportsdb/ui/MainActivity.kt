package com.madonasyombua.sportsdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.madonasyombua.sportsdb.ui.screen.MainViewModel
import com.madonasyombua.sportsdb.ui.screen.TeamScreen
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.leaguesLiveData.observe(this, Observer {
            Timber.d("leagues ${it.size}")
        })
        setContent {
            MaterialTheme {
                MyApp()
            }
        }

    }

}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        TeamScreen()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MaterialTheme {
        MyApp()
    }
}
