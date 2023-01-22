package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.ui.theme.CatsClubTheme
import com.example.catsclub.ui.theme.feed.RoundedHeader

@Composable
fun PhotosCard (groupedPhotos: Map<String, List<Int>>) {
    val groups = groupedPhotos.keys.toList()
    RoundedHeader(title = "Photos")
    Surface() {
        Column {
            val padding = 16.dp
            var selectedGroup by remember {
                mutableStateOf(groups.first())
            }
            PhotosTab(groups = groups, selectedGroup = selectedGroup, onSelected = {selectedGroup = it}
            )
            PhotosGrid(images = groupedPhotos.getValue(selectedGroup),
                        Modifier.padding(
                            top = padding / 2,
                            start = padding,
                            end = padding,
                            bottom = padding
                        )
                )
        }

    }
}

@Preview
@Composable
fun PhotosCardPreview () {
    val grouped = mapOf(
    "Today" to listOf(
        R.drawable.user2_1,
        R.drawable.user2_2,
        R.drawable.user2_3
    ),
    "Hobby" to listOf(
        R.drawable.user2_4,
        R.drawable.user2_5,
        R.drawable.user2_6
    )
    )
    CatsClubTheme() {
        Surface() {
            PhotosCard(groupedPhotos = grouped)
        }

    }
}
