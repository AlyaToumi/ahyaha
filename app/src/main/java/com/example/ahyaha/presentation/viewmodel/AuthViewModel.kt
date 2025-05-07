package com.example.ahyaha.presentation.viewmodel


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    var authState by mutableStateOf<AuthState>(AuthState.Idle)
        private set

    private val auth = FirebaseAuth.getInstance()

    fun loginOrRegister(email: String, password: String) {
        authState = AuthState.Loading

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                authState = AuthState.Success
            }
            .addOnFailureListener {
                // إذا فشل تسجيل الدخول، نحاول إنشاء حساب
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        authState = AuthState.Success
                    }
                    .addOnFailureListener { signupError ->
                        authState = AuthState.Error(signupError.message ?: "حدث خطأ أثناء التسجيل")
                    }
            }
    }

    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        object Success : AuthState()
        data class Error(val message: String) : AuthState()
    }
}
