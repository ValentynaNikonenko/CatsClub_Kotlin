package com.example.catsclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.catsclub.model.UsersViewModel
import com.example.catsclub.ui.theme.CatsClubTheme
import com.example.catsclub.ui.theme.feed.Feed
import com.example.catsclub.ui.theme.profile.Profile


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: UsersViewModel by viewModels()
        setContent {
            CatsClubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: UsersViewModel) {
    val state by viewModel.users.collectAsState()
    var selectedId by remember {
        mutableStateOf<String?>(null)
    }
    Crossfade(targetState = selectedId) { id ->
        if (id == null) {
            Feed(users = state, onSelected = { user ->
                selectedId = user.id
            })
        }
        else { Profile (user = viewModel.getById(id))
         BackHandler {selectedId = null}
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatsClubTheme {
        MainScreen(UsersViewModel())
    }
}