package com.evicky.feature.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class RegisterScreenUiState(val name: String = "")

class RegisterViewModel: ViewModel() {

    internal var registerUiState = MutableStateFlow(RegisterScreenUiState())
        private set

    fun setName(name: String) {
        registerUiState.value = registerUiState.value.copy(name = name)
    }

}