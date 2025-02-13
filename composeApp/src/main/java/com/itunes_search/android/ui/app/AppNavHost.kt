package com.itunes_search.android.ui.app

import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.itunes_search.android.ui.details.DetailsScreen
import com.itunes_search.android.ui.main.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
object Details

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel: AppNavHostViewModel = hiltViewModel()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Main
    ) {
        composable<Main> {
            MainScreen(
                onContentClick = {
                    viewModel.setContent(it)
                    navController.navigate(Details)
                }
            )
        }

        composable<Details> {
            DetailsScreen(
                content = viewModel.selectedContent.value,
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}