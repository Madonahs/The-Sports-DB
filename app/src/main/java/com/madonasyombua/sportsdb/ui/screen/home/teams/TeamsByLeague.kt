package com.madonasyombua.sportsdb.ui.screen.home.teams

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.madonasyombua.sportsdb.data.remote.model.League
import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by Loveth Nwokike
 * on 3/20/2021
 * */
@ExperimentalFoundationApi
@Composable
fun TeamsDisplayGrid(league: League, navController: NavController) {
    val teamsViewModel: TeamsViewModel = hiltNavGraphViewModel()
    val teams = teamsViewModel.teamsLiveData.observeAsState()
    LazyVerticalGrid(
        cells = GridCells.Fixed(3), modifier = Modifier.padding(10.dp),
        state = rememberLazyListState()
    ) {
        teamsViewModel.getTeamsByLeague(league.name)

        items(teams.value ?: emptyList()) { team ->
            TeamGridItem(team = team, navController = navController)
        }

    }
}

@Composable
fun TeamGridItem(team: TeamByLeague, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(shape = RoundedCornerShape(6.dp))
            .padding(10.dp)
            .clickable(onClick = {
                navController.navigate("teamdetails/${team.teamId}")
            })
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImage(data = team.badgeUrl, contentDescription = null)
            Text(text = team.teamName, style = MaterialTheme.typography.subtitle1)
        }
    }

}