package com.madonasyombua.sportsdb.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen

@Composable
fun AppBar(title: String, actions: @Composable RowScope.() -> Unit = {}) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        backgroundColor = mediumSeaGreen,
        actions = actions
    )
}