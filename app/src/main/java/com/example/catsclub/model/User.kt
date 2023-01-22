package com.example.catsclub.model

data class User(
    var id: String,
    val name: String,
    val lastOnline: String,
    val avatar: Int,
    val coverImage: Int,
    val numOfFollowers: String,
    val numOfFollowing: String,
    val tags: List<String>,
    val photos: Map<String, List<Int>>
        )
