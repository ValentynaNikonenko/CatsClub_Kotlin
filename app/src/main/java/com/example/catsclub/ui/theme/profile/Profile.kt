package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.model.User
import com.example.catsclub.ui.theme.CatsClubTheme



@Composable
fun Profile (user: User, modifier: Modifier = Modifier) {
    val padding = 16.dp
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            ProfileHeader(user = user)
            Spacer(modifier = Modifier.weight(1f))
            TagsList(tags = user.tags,
                    modifier = Modifier.padding(top = padding, bottom = padding)
            )
            Spacer(modifier = Modifier.weight(1f))
            PhotosCard(groupedPhotos = user.photos)
        }
    }
}

@Preview
@Composable
fun  ProfilePreview () {

    val user = User(
        "1",
        "Asya May",
        "3 minutes ago",
        R.drawable.user3_2,
        R.drawable.image1_1,
        "100K",
        "1.5K",
        listOf(
            "cat",
            "food",
            "lifestyle",
            "catstyle"
        ),
        mapOf(
            "Today" to listOf(
                R.drawable.user1_1,
                R.drawable.user1_2,
                R.drawable.user1_3
            ),
            "Hobby" to listOf(
                R.drawable.user1_4,
                R.drawable.user1_5,
                R.drawable.user1_6
            )
        )
    )
    CatsClubTheme {
        Surface() {
            Profile(user)
        }
    }
}