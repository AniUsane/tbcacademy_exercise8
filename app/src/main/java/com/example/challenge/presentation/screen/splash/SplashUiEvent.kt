package com.example.challenge.presentation.screen.splash

sealed class SplashUiEvent {
    data object NavigateToConnections : SplashUiEvent()
    data object NavigateToLogIn : SplashUiEvent()
}
