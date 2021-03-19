package com.madonasyombua.sportsdb.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.material.*
import com.madonasyombua.sportsdb.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.madonasyombua.sportsdb.ui.screen.LeagueTab
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
                    val leaguesState = viewModel.state.observeAsState()
                      val selected = leaguesState.value?.selectedLeague

                    Scaffold(topBar = {
                        AppBar()
                    },modifier = Modifier.background(color = Color.White)) {
                        leaguesState.value?.leagues?.let {leagues->
                            selected?.let {
                                LeagueTab(
                                    leagues = leagues.take(20),
                                    selectedLeague = it,
                                    onLeagueSelected = viewModel::onLeagueSelected
                                )
                            }
                        }
    }
}



@Composable
fun AppBar() {
    TopAppBar(title = {
        Text(text = "Sports App", color = Color.White)
    },
                backgroundColor = mediumSeaGreen,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(
                    onClick = { /* TODO: Open search */ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.cd_search),
                        tint = Color.White
                    )
                }
            }
        })
}