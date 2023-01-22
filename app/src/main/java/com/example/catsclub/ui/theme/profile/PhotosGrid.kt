package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.ui.theme.CatsClubTheme
import com.example.catsclub.ui.theme.feed.RoundedHeader
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosGrid(
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 100.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(images) { images ->
            Image(
                painter = painterResource(id = images),
                contentDescription = "photo",
                modifier = Modifier.aspectRatio(1f).clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Preview
@Composable
fun PhotoGridPreview () {
    CatsClubTheme() {
        val images = listOf(
            R.drawable.user1_1,
            R.drawable.user1_2,
            R.drawable.user1_3,
            R.drawable.user1_4,
            R.drawable.user1_5,
            R.drawable.user1_6,
        )
        PhotosGrid(images = images)
    }
}