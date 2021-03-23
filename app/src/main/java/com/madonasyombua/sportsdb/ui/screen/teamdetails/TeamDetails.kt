package com.madonasyombua.sportsdb.ui.screen.teamdetails

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.TableChart
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.madonasyombua.sportsdb.R
import com.madonasyombua.sportsdb.ui.theme.mediumSeaGreen
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
fun TeamDetailsScreen(url:String) {
    val navController = rememberNavController()
    Scaffold(topBar= { com.madonasyombua.sportsdb.ui.components.AppBar(title = "",actions =
    {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            CoilImage(data = url, contentDescription = "null")
        }

    })}, bottomBar =
    { TeamBottomNavigation(navController) }) {
        NavHost(navController, startDestination = Screen.Event.route) {
            composable(Screen.Event.route) { TeamEventsScreen() }
            composable(Screen.Equipment.route) {  }
            composable(Screen.Table.route){}
        }
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
        backgroundColor =  mediumSeaGreen
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
                label = { Text(text = stringResource(id = screen.resourceId)) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) })
        }
    }
}
@Preview("Light Theme")
@Composable
fun LightPreview() {
    MaterialTheme {
        TeamDetailsScreen("")
    }
}