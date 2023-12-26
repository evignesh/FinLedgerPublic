package com.evicky.feature.register

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.evicky.feature.util.REGISTER_ROUTE
import com.evicky.utility.logger.Log

fun NavController.navigateToRegisterScreen(data: String) {
    navigate("$REGISTER_ROUTE/$data")
}

private const val PHONE_NO_KEY = "phoneNumberKey"

fun NavGraphBuilder.registerScreen() {
    composable(route = "$REGISTER_ROUTE/{$PHONE_NO_KEY}") {
        val receivedPhoneNumber = it.arguments?.getString(PHONE_NO_KEY) ?: ""
        RegisterScreen(phoneNumber = receivedPhoneNumber)
    }
}
