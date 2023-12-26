package com.evicky.feature.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class SignInUiState(
    val phoneNumber: String = "",
    val isLoginSuccess: Boolean = false,
    val errorMessage: String = ""
)

private const val SIGNIN_VM_SAVED_STATE_HANDLE_KEY = "signInVMSavedStateHandleKey"

class SignInViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    var signInUiState = MutableStateFlow(SignInUiState())
        private set

    init {
        savedStateHandle.get<SignInUiState>(SIGNIN_VM_SAVED_STATE_HANDLE_KEY)?.let { signInUiState.value = it }
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        signInUiState.value = signInUiState.value.copy(phoneNumber = phoneNumber)
        if (phoneNumber.length != 10) {
            setPhoneNumberFieldErrorMessage("Invalid mobile number.")
        } else {
            setPhoneNumberFieldErrorMessage("")
        }
    }

    private fun setPhoneNumberFieldErrorMessage(errorMessage: String) {
        signInUiState.value = signInUiState.value.copy(errorMessage = errorMessage)
    }

    override fun onCleared() {
        super.onCleared()
        //To not to lose data during android low memory kill
        savedStateHandle[SIGNIN_VM_SAVED_STATE_HANDLE_KEY] = signInUiState
    }



}