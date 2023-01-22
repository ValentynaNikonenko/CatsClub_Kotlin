package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catsclub.R
import com.example.catsclub.model.User
import com.example.catsclub.ui.theme.CatsClubTheme
import com.example.catsclub.ui.theme.feed.Feed

@Composable
fun TagsList (tags: List<String>, modifier: Modifier = Modifier) {
    val padding = 8.dp
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = padding * 2, end = padding),
        horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
        items(tags) {
            Text(
                text = it,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .border(
                        1.dp,
                        LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                        CircleShape
                    )
                    .padding(padding)
            )
        }
    }
}
@Preview
@Composable
fun TagPreview() {
    val user = User(
        "1",
        "Asya May",
        "3 minutes ago",
        R.drawable.avatar_1,
        R.drawable.image1_1,
        "15K",
        "9,5K",
        listOf("travel","home","lifestyle"),
        emptyMap()
    )
    CatsClubTheme {
        Surface() {
         TagsList(user.tags)
        }
    }
}
