package com.kukki.imageloading.ui

import Album
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.kukki.imageloading.di.ProductsViewModel
import com.kukki.imageloading.utiltiy.CustomTopAppBar
import com.kukki.imageloading.utiltiy.ListProductRowView
import com.kukki.imageloading.utiltiy.NavDest
import com.kukki.imageloading.ui.theme.MandysPink
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AlbumListView(
    navController: NavHostController,
    productsViewModel: ProductsViewModel = viewModel(),
) {

    val albumList = productsViewModel.albumList.observeAsState()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                topAppBarText = "Albums",
                onBackPressed = {

                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            LazyColumn(content = {

                itemsIndexed(
                    items = albumList.value ?: ArrayList(),
                    itemContent = { _, albumData: Album ->
                        ListProductRowView(item = albumData, imgPath = albumData.thumbnailUrl, onClick = {
                            val img = albumData.url
                            val encodedUrl = URLEncoder.encode(img, StandardCharsets.UTF_8.toString())

                            navController.navigate(NavDest.imagePreviewScreen.plus("/$encodedUrl"))
                        })

                        Divider()
                    }
                )
            })
        }
    }
}
