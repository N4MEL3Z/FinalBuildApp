package com.example.buildapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class BuildAppNav() { //for routes
    Start,
    CatalogScreen
}

@Composable
fun TopicApp(
    navController: NavController = rememberNavController()
)
{
    NavHost(
        navController = navController as NavHostController,
        startDestination = BuildAppNav.Start.name,
        modifier = Modifier
            .fillMaxSize()
        ){
        composable(route = BuildAppNav.Start.name) {
            BuildAppStart(
                onNextButtonClicked = {
                    navController.navigate(BuildAppNav.CatalogScreen.name)
                }
            )
        }
        composable(route = BuildAppNav.CatalogScreen.name) {
            TopicGrid(
            )//the list of repices..


    }


}
}