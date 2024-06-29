package com.example.apuntes_jetpackcompose.navigation

sealed class AppScreens(val route:String) {
    object firstScreen:AppScreens("firstScreen")
    object secondScreen:AppScreens("secondScreen")
    object calcScreen:AppScreens("calcScreen")
    object calcSimple:AppScreens("calcSimple")
    object contadorViewModel:AppScreens("CounterScreen")
}