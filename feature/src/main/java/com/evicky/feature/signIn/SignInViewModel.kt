package com.evicky.feature.signIn

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evicky.core.model.local.SignInLocalData
import com.evicky.core.usecase.SignInUseCase
import com.evicky.utility.logger.Log
import com.evicky.utility.utils.CoroutineDispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class SignInUiState(
    val phoneNumber: String = "",
    val isLoginSuccess: Boolean = false,
    val errorMessage: String = ""
)

private const val SIGNIN_VM_SAVED_STATE_HANDLE_KEY = "signInVMSavedStateHandleKey"
private const val logTag = "SignInViewModel"

class SignInViewModel(private val savedStateHandle: SavedStateHandle, private val signInUseCase: SignInUseCase, private val coroutineDispatcherProvider: CoroutineDispatcherProvider): ViewModel() {

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

    fun writeDataToDataSource() {
        viewModelScope.launch(coroutineDispatcherProvider.io()) {
            val isWriteSuccess = signInUseCase.writeData(data = SignInLocalData(id = 1L, name = "eVicky"), logTag = "$logTag:writeDataToDataSource")
            Log.i("$logTag:writeDataToDataSource", "isWriteSuccess: $isWriteSuccess")
        }
    }

    fun readDataFromDataSource() {
        viewModelScope.launch(coroutineDispatcherProvider.io()) {
            val signInLocalData = signInUseCase.readData(path = "Users/UserId")
            Log.i("$logTag:readDataFromDataSource", "signInLocalData: $signInLocalData")
        }
    }

    override fun onCleared() {
        super.onCleared()
        //To not to lose data during android low memory kill
        savedStateHandle[SIGNIN_VM_SAVED_STATE_HANDLE_KEY] = signInUiState
    }



}