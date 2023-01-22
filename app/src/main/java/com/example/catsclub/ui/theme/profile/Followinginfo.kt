package com.example.catsclub.ui.theme.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun Followinginfo (text: String, number: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text (text = number, style = MaterialTheme.typography.subtitle2)
        Text (text = text, style = MaterialTheme.typography.caption)

    }
}