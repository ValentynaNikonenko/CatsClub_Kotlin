package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.model.User
import com.example.catsclub.ui.theme.CatsClubTheme
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Column


@Composable
fun ProfileHeader (user: String) {
    val padding = 16.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding, end = padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(user.avatar),
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.size(padding))
        Column {
            Text(
                text = user.name,
                style = MaterialTheme.typography.h6
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Followinginfo(text = "followers", number = user.numOfFollowers)
                Followinginfo(text = "following", number = user.numOfFollowing)
                Button(onClick = {}, shape = CircleShape) {
                    Text(text = "Follow")
                }

            }

        }
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    val user = User(
        "2",
        "Marty Cat",
        "15 minutes ago",
        R.drawable.avatar_2,
        R.drawable.imag_2,
        "110K",
        "1.2K",
        emptyList(),
        emptyMap()
    )
    CatsClubTheme {
        Surface {
            ProfileHeader(user = user)
        }
    }
}
