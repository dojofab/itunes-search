package com.itunes_search.android.ui.app

import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.itunes_search.android.ui.details.DetailsScreen
import com.itunes_search.android.ui.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
data class Details(
    val name: String
)

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    adaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Main
    ) {
        composable<Main> {
            MainScreen(
                adaptiveInfo = adaptiveInfo,
                onItemClick = {
                    navController.navigate(
                        Details(
                            name = it
                        )
                    )
                }
            )
        }

        composable<Details> {
            val args = it.toRoute<Details>()
            DetailsScreen(
                adaptiveInfo = adaptiveInfo,
                item = args.name
            )
        }
    }
}