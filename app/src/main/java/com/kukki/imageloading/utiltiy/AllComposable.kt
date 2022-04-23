package com.kukki.imageloading.utiltiy

import Album
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kukki.imageloading.R
import com.quantic.mob.app.theme.TitleAppBar


@Composable
fun CustomTopAppBar(topAppBarText: String, onBackPressed: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                style = TitleAppBar
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Image(
                    painter = painterResource(R.drawable.ic_backspace),
                    contentDescription = "back",
                )
            }
        },
        actions = {

        },
        elevation = 0.dp,
    )
}


@Composable
fun ListProductRowView(item: Album?, imgPath: String? = null, onClick: (Album?) -> Unit) {
    val title = item?.title
    Row(
        Modifier
            .fillMaxWidth() // full length click ripple
            .padding(vertical = 20.dp)
            .padding(horizontal = 8.dp)
            .clickable(onClick = { onClick(item) }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .border(width = 1.dp, color = Color.Gray)
                    .align(alignment = Alignment.CenterVertically)
                    .padding(2.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imgPath),
                    contentDescription = title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(60.dp)
                )
            }

        }

        Text(title ?: "", style =  TextStyle.Default, textAlign = TextAlign.Center)

    }
}