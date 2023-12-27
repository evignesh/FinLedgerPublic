package com.evicky.financeledger.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.evicky.feature.signIn.signInNavGraph
import com.evicky.feature.postlogin.navigateToPostLoginScreen
import com.evicky.feature.postlogin.postLoginNavGraph
import com.evicky.feature.util.SIGNIN_ROUTE

@Composable
internal fun RootHost() {
    val rootController = rememberNavController()
    NavHost(
        navController = rootController,
        startDestination = SIGNIN_ROUTE,
    ) {
        signInNavGraph(
            onSignInPress = {
                rootController.navigateToPostLoginScreen(it)
            }
        )
        postLoginNavGraph()
    }

}