package com.example.asartask.model

import java.io.Serializable

data class Header(
    val headerTitle: String,
    val headerSubtitle: String,
    val headerSubtitle2: String,
    val headerImage: String,
) : Serializable

