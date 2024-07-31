package com.example.nestednavigation.nav

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nestednavigation.Screens.DetailScreen
import com.example.nestednavigation.Screens.Home
import com.example.nestednavigation.Screens.ID
import com.example.nestednavigation.Screens.NAME
import com.example.nestednavigation.Screens.Screen
import com.example.nestednavigation.Screens.Third
import java.util.jar.Attributes.Name

@Composable
fun HomeNavGraph(navController: NavHostController) {

    val TAG = "myTag"

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            Home(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(ID){
                type = NavType.IntType
            }, navArgument(NAME){
                type = NavType.StringType
            })
        ){
            val arg = it.arguments?.getInt(ID).toString()
            val name = it.arguments?.getString(NAME).toString()
            Log.e(TAG, arg)
            Log.e(TAG, name)
            DetailScreen(navController)
        }
        composable(route = Screen.Third.route){
            Third(navController = navController)
        }

    }

}