package com.example.challenge.data.model

import com.squareup.moshi.Json

data class LogInDto(
    val needsMfa: Boolean? = null,
    @Json(name = "AccessToken")
    val accessToken: String? = null,
    @Json(name = "RefreshToken")
    val refreshToken: String? = null
)