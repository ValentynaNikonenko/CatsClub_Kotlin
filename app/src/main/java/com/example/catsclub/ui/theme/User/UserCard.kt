package com.example.catsclub.ui.theme.User

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.model.User
import com.example.catsclub.ui.theme.CatsClubTheme

@Composable
fun UserCard (
    user: User,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val padding = 16.dp
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding /2
            )
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = user.avatar),
                contentDescription ="Avatar",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Spacer(Modifier.size(padding))
            Column() {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
                )
                Text(text = user.lastOnline,
                Modifier.alpha(0.5f)
                    )

            }
        }
        Spacer(Modifier.size(padding))
        Image(
            painter = painterResource(id = user.coverImage),
            contentDescription = "Cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(4.dp), clip = true),
            contentScale = ContentScale.Crop
            )
    }
}

@Preview
@Composable
fun UserCardPreview() {
    val user = User(
        "1",
        "Asya May",
        "3 minutes ago",
        R.drawable.avatar_1,
        R.drawable.image1_1,
        "0",
        "0",
        emptyList(),
        emptyMap()
    )
    CatsClubTheme {
        Surface {
            UserCard(user, {})
        }
    }
}

