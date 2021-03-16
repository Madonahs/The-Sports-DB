package com.madonasyombua.sportsdb.ui.screen

import androidx.compose.material.*
import com.madonasyombua.sportsdb.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen

@Composable
fun TeamScreen() {
    Scaffold(topBar = {
        AppBar()
    }) {

    }
}

@Composable
fun AppBar() {
    TopAppBar(title = {
        Text(text = "Sports App",color = Color.White)
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