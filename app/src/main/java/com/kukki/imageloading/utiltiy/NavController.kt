package com.kukki.imageloading.utiltiy

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kukki.imageloading.ui.AlbumListView
import com.kukki.imageloading.ui.ImagePreviewScreen
import com.kukki.imageloading.ui.SplashScreen

/**
 * MainNavDestinations used in the ([MainApp]).
 */
object NavDest {
    const val landingScreen = "landingScreen"
    const val albumListPreview = "albumListPreview"
    const val imagePreviewScreen = "imagePreviewScreen"
}

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDest.albumListPreview
) {

    NavHost(navController, startDestination,
        builder = {
            composable(NavDest.landingScreen) { SplashScreen(navController) }
            composable(NavDest.albumListPreview) { AlbumListView(navController) }
            composable(NavDest.imagePreviewScreen.plus("/{imagePath}")) { backStackEntry ->
                ImagePreviewScreen(navController, backStackEntry.arguments?.getString("imagePath"))
            }
//
        })
}