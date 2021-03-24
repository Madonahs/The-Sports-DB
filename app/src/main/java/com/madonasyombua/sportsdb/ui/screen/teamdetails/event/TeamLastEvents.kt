package com.madonasyombua.sportsdb.ui.screen.teamdetails.event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.sportsdb.data.remote.model.Event
import com.madonasyombua.sportsdb.ui.theme.seaGreen
import dev.chrisbanes.accompanist.coil.CoilImage
import timber.log.Timber

/**
 * Created by Loveth Nwokike
 * 3/23/2021
 * */
@Composable
fun TeamEventsScreen(viewModel: TeamEventViewModel) {
val es = mutableListOf<Event>()
    val events = viewModel.eventsLiveData.observeAsState()
    LazyColumn(
        modifier = Modifier
            .background(
                color =
                Color(0xeeecf1)
            )
            .fillMaxHeight()
    ) {
        events.value?.let {events->
            items(events.size) { index ->
                    EventsCardItem(event = events[index], viewModel)

            }}
    }

}


@Composable
fun EventsCardItem(event: Event, viewModel: TeamEventViewModel) {

    val teamDetails = viewModel.teamDetailsLiveData.observeAsState()
    viewModel.getAwayTeamDetails(event.awayTeamId)
    Card(modifier = Modifier.padding(10.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .background(color = seaGreen)
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = event.leagueName,color = Color.White )
            }



            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                teamDetails.value?.get(0)?.let {
                    CoilImage(
                        data = it.badgeUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .padding(end = 4.dp, bottom = 8.dp),contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = event.homeTeam,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    modifier = Modifier.width(70.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "  ${event.homeScore}  -  ",
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp, textAlign = TextAlign.Justify
                )
                Text(
                    text = event.awayScore.plus("  "),
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp, textAlign = TextAlign.Justify
                )
                Text(
                    text = event.awayTeam,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(80.dp)
                )

                val awayTeam = viewModel.teamAwayDetailsLiveData.observeAsState()
                awayTeam.value?.get(0)?.let {
                    Timber.e(event.homeTeamId)
                    if (it.teamId == event.awayTeamId)
                        event.badge = it.badgeUrl
                       CoilImage(data = event.badge ,contentDescription = null,  modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .padding(start = 4.dp, bottom = 8.dp),contentScale = ContentScale.Crop)


                }
            }

            Text(
                text = event.eventDate,
                fontStyle = FontStyle.Italic,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                color = Color.Gray
            )

        }
    }
}

@Preview
@Composable
fun EventPreview() {
    //TeamEventsScreen()
}