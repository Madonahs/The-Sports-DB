package com.madonasyombua.sportsdb.ui.screen.teamdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.sportsdb.data.remote.model.Event
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen
import com.madonasyombua.sportsdb.ui.theme.seaGreen

@Composable
fun TeamEventsScreen() {
    val events = listOf<Event>(
        Event(
            leagueName = "Premier League",
            homeTeam = "Arsenal",
            awayTeam = "Chelsea",
            homeScore = "4",
            awayScore = "1",
            eventDate = "2021-03-10"
        )
    )
    LazyColumn(modifier = Modifier.background(color =
    Color(0xeeecf1)).fillMaxHeight()) {
        items(events) {
            EventsCardItem(event = it)
        }
    }

}


@Composable
fun EventsCardItem(event: Event) {
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
                Text(text = event.leagueName ?: "League Name")
            }

            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = event.homeTeam,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "  ${event.homeScore}  -  ",
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp, textAlign = TextAlign.Center
                )
                Text(
                    text = event.awayScore.plus("  "),
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp, textAlign = TextAlign.Center
                )
                Text(
                    text = event.awayTeam,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
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
    TeamEventsScreen()
}