package com.evicky.financeledger.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.evicky.feature.login.signInScreen
import com.evicky.feature.register.navigateToRegisterScreen
import com.evicky.feature.register.registerScreen
import com.evicky.feature.util.SIGNIN_ROUTE
import com.evicky.utility.logger.Log

@Composable
internal fun RootHost() {
    val rootController = rememberNavController()
    NavHost(
        navController = rootController,
        startDestination = SIGNIN_ROUTE,
    ) {
        signInScreen(
            onSignInPress = {
                rootController.navigateToRegisterScreen(it)
            }
        )
        registerScreen()
    }

}