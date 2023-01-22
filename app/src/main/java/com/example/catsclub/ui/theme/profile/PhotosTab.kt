package com.example.catsclub.ui.theme.profile

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.catsclub.ui.theme.CatsClubTheme
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.semantics.Role.Companion.Tab

@Composable
fun PhotosTab (groups: List<String>,
               selectedGroup: String,
               onSelected: (String) -> Unit) {
    val selectedIndex = groups.indexOf(selectedGroup)
    TabRow(selectedTabIndex = selectedIndex,
        backgroundColor = MaterialTheme.colors.surface
    )
    {
    groups.forEachIndexed { index, group ->
        val color = animateColorAsState(
            if (selectedGroup == group) MaterialTheme.colors.primary else
                MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
        )
        Tab(
           selected = index == selectedIndex,
           onClick = {onSelected(group)},
           text = {Text(text = group, color = color.value)},
           selectedContentColor = MaterialTheme.colors.surface
        )
    }
    }
}

@Preview
@Composable
fun TabPreview () {
    CatsClubTheme() {
        var selectedGroup by remember { mutableStateOf("food") }
        PhotosTab(
            groups = listOf("selfie", "cats", "lifestyle"),
            selectedGroup =selectedGroup
        ) { selectedGroup = it }

    }

    }

