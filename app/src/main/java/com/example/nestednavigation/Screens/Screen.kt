package com.example.nestednavigation.Screens

const val ID = "id"
const val NAME = "name"
sealed class Screen(val route: String){
    object Home: Screen(route = "Home")
    object Detail: Screen(route = "Detail?id={$ID}&name={$NAME}"){
        fun putIdName(id: Int = 0, name: String = "Raju"): String{
            return  "Detail?id=$id&name=$name"
        }
    }
    object Third: Screen(route = "Third")
    object Login: Screen(route = "Login")
    object SignUp: Screen(route = "SignUp")

}
