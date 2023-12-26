package com.evicky.feature.postlogin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.evicky.feature.util.POST_LOGIN_ROUTE

fun NavController.navigateToPostLoginScreen(data: String) {
    navigate("$POST_LOGIN_ROUTE/$data")
}

private const val PHONE_NO_KEY = "phoneNumberKey"

fun NavGraphBuilder.postLoginScreen() {
    composable(route = "$POST_LOGIN_ROUTE/{$PHONE_NO_KEY}") {
        val receivedPhoneNumber = it.arguments?.getString(PHONE_NO_KEY) ?: ""
        PostLoginScreen(phoneNumber = receivedPhoneNumber)
    }
}
