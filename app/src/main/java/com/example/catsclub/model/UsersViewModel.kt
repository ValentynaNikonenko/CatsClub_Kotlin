package com.example.catsclub.model

import androidx.lifecycle.ViewModel
import com.example.catsclub.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class UsersViewModel: ViewModel() {
    val users = MutableStateFlow<List<User>>(emptyList())

    fun  getById(id: String) = users.value.first { user -> user.id = id }

    init {
        users.update {
            mutableListOf(
                User (
                    "1",
                    "Asya May",
                    "3 minutes ago",
                    R.drawable.avatar_1,
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
                ),
            User (
                "2",
                "Marty Cat",
                "15 minutes ago",
                R.drawable.avatar_2,
                R.drawable.imag_2,
                "110K",
                "1.2K",
                listOf(
                    "cat",
                    "travel",
                    "lifestyle",
                    "catstyle",
                    "friend"
                ),
                mapOf(
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
            ),
                User (
                    "3",
                    "Alysa Myr",
                    "7 minutes ago",
                    R.drawable.avatar_3,
                    R.drawable.imag_3,
                    "90K",
                    "2K",
                    listOf(
                        "cat",
                        "food",
                        "lifestyle",
                        "catstyle",
                        "hobby"
                    ),
                    mapOf(
                        "Today" to listOf(
                            R.drawable.user3_1,
                            R.drawable.user3_2,
                            R.drawable.user3_3
                        ),
                        "Hobby" to listOf(
                            R.drawable.user3_4,
                            R.drawable.user3_5,
                            R.drawable.user3_6

                        )
                    )
                ),
            )
        }

    }}

private fun <User> List<User>.first(predicate: (User) -> Unit) { }

