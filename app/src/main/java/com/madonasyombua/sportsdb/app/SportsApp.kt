package com.madonasyombua.sportsdb.app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.madonasyombua.sportsdb.ui.screen.home.HomeScreen
import com.madonasyombua.sportsdb.ui.screen.teamdetails.TeamDetailsScreen
import com.madonasyombua.sportsdb.ui.screen.teamdetails.TeamEventsScreen

@ExperimentalFoundationApi
@Composable
fun TheSportsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("teamdetails/{url}") {entry->
            TeamDetailsScreen(entry.arguments?.getString("url")!!) }
    }
}


