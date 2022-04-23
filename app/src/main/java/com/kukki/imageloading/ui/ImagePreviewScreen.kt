package com.kukki.imageloading.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kukki.imageloading.utiltiy.CustomTopAppBar
import com.kukki.imageloading.ui.theme.PurpleLight

@Composable
fun ImagePreviewScreen(
    navController: NavController,
    imgPath: String?,
) {

    Scaffold(
        topBar = {
            CustomTopAppBar(
                topAppBarText = "Image View",
                onBackPressed = {
                    navController.navigateUp()
                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            Image(
                painter = rememberAsyncImagePainter(imgPath),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            )
        }
    }
}