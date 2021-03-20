package com.madonasyombua.sportsdb.ui.screen.teams

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by Loveth Nwokike
 * on 3/20/2021
 * */
@ExperimentalFoundationApi
@Composable
fun TeamsDisplayGrid(viewModel: TeamsViewModel){
    val teams = viewModel.teamsLiveData.observeAsState()
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.padding(10.dp),
        state = rememberLazyListState()) {
             items(teams.value ?: emptyList()) {
                 team->
                 TeamGridItem(team = team)
             }
    
}
}

@Composable
fun TeamGridItem(team: TeamByLeague){
Card(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()
    .clip(shape = RoundedCornerShape(6.dp)).padding(10.dp)) {
    Column(modifier = Modifier.padding(8.dp),horizontalAlignment = Alignment.CenterHorizontally) {
      CoilImage(data = team.badgeUrl,contentDescription = null)
        Text(text =team.teamName,textAlign = TextAlign.Center)
    }
}

}