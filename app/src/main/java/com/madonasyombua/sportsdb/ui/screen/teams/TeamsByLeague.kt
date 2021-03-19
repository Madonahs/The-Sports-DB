package com.madonasyombua.sportsdb.ui.screen.teams

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun TeamsDisplayGrid(){

}

@Composable
fun TeamGridItem(team: TeamByLeague){
Card(modifier = Modifier.fillMaxWidth().fillMaxHeight().clip(shape = RoundedCornerShape(6.dp))) {
    Column() {
      CoilImage(data = team.badgeUrl,contentDescription = null)
        Text(text =team.teamName )
    }
}

}