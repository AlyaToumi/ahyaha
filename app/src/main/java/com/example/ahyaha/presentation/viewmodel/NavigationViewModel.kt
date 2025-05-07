package com.example.ahyaha.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    var currentScreen = mutableStateOf("login") // بداية بتحديد الشاشة الأولى "login"

    fun navigateTo(screen: String) {
        currentScreen.value = screen
    }
}

