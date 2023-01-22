package com.example.catsclub.ui.theme.feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.catsclub.R
import com.example.catsclub.ui.theme.CatsClubTheme
import com.example.catsclub.model.User
import com.example.catsclub.ui.theme.User.UserCard

@Composable
fun Feed (
    users: List<User>,
    onSelected: (User) -> Unit,
    modifier: Modifier = Modifier
    ) {
    Surface(modifier = modifier.fillMaxSize()) {
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            item { FeedHeader() }
            items(users) { user ->
                UserCard(user = user, onClick = { onSelected(user)})
            }
        }

    }

}

@Preview
@Composable
fun FeedPreview() {
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
     Feed(users = listOf(user), onSelected ={} )
    }
}