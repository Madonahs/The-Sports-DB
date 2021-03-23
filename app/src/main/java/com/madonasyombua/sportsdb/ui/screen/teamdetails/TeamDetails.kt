package com.madonasyombua.sportsdb.ui.screen.teamdetails

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.madonasyombua.sportsdb.ui.components.AppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import com.madonasyombua.sportsdb.R
import com.madonasyombua.sportsdb.ui.screen.teamdetails.event.TeamEventViewModel
import com.madonasyombua.sportsdb.ui.screen.teamdetails.event.TeamEventsScreen
import com.madonasyombua.sportsdb.ui.theme.seaGreen
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * created by Loveth Nwokike
 * 3/22/2021
 * */
sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Event : Screen("event", R.string.event,Icons.Outlined.Event)
    object Equipment : Screen("equipment", R.string.equip,Icons.Outlined.Person)
    object Table : Screen("table", R.string.table,Icons.Outlined.TableChart)
}


@Composable
fun TeamDetailsScreen(id:String) {
    val viewModel : TeamEventViewModel = hiltNavGraphViewModel()
    viewModel.getTeamDetails(id)
    val teamDetails = viewModel.teamDetailsLiveData.observeAsState()
    val navController = rememberNavController()
    Scaffold(topBar= { AppBar(title = "",actions =
    {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            teamDetails.value?.get(0)?.badgeUrl?.let { CoilImage(data = it, contentDescription = "null") }
        }

    },color = seaGreen)}, bottomBar =
    { TeamBottomNavigation(navController) }) {
        Box(modifier = Modifier.padding(it)){
        NavHost(navController, startDestination = Screen.Event.route) {
            composable(Screen.Event.route) { TeamEventsScreen(viewModel)
                viewModel.getLastTeamEvents(id)
            }
            composable(Screen.Equipment.route) {  }
            composable(Screen.Table.route){}
        }}
    }
}


@Composable
fun TeamBottomNavigation(navController:NavController) {
    val items = listOf(
        Screen.Event,
        Screen.Equipment,
        Screen.Table
    )
    BottomNavigation(
        backgroundColor =  seaGreen
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        items.forEach { screen ->
            BottomNavigationItem(selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
                },
                selectedContentColor = Color.White,
                unselectedContentColor= Color.Black,
                label = { Text(text = stringResource(id = screen.resourceId)) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) })
        }
    }
}
@Preview("Light Theme")
@Composable
fun LightPreview() {
    MaterialTheme {
        //TeamDetailsScreen("")
    }
}