package com.madonasyombua.sportsdb.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.madonasyombua.sportsdb.data.remote.model.League
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen

/**
 * Created by Loveth Nwokike
 * on 3/17/2021
 * */
@Composable
fun LeagueTab(leagues:List<League>,selectedLeague:League,onLeagueSelected:(League)->Unit){

    val selectedIndex = leagues.indexOfFirst { it == selectedLeague }
        ScrollableTabRow(
            divider = {},
            selectedTabIndex = selectedIndex,
            edgePadding =8.dp,
            backgroundColor = Color.White,
            contentColor = mediumSeaGreen) {
            leagues.forEachIndexed { index, league ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = { onLeagueSelected(league)},
                      ) {
                    LeagueChoice(
                        text = league.name,
                        selected = index == selectedIndex,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp)
                    )
                }
        }
    }
}

@Composable
private fun LeagueChoice(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier,
        color = mediumSeaGreen
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp,top = 8.dp,bottom = 8.dp)
        )
    }
}