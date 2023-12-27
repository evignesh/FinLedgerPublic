package com.evicky.feature.signIn

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.evicky.feature.util.SIGNIN_ROUTE
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.signInNavGraph(
    onSignInPress: (String) -> Unit
) {
    composable(route = SIGNIN_ROUTE) {
        val viewModel: SignInViewModel =  koinViewModel()
        val loginUiState by viewModel.signInUiState.collectAsStateWithLifecycle()
        SignInScreen(
            signInUiState = loginUiState,
            onSignInPress = { if (loginUiState.errorMessage.isEmpty() && loginUiState.phoneNumber.isNotEmpty()) onSignInPress.invoke(it) },
            onPhoneNumberChange = { updatedValue ->
                viewModel.onPhoneNumberChange(updatedValue)
            }
        )
    }
}
