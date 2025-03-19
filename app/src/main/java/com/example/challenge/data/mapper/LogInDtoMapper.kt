package com.example.challenge.data.mapper

import com.example.challenge.data.model.LogInDto
import com.example.challenge.domain.model.GetToken

fun LogInDto.toDomain() =
    GetToken(
        needsMfa = needsMfa ?: false,
        accessToken = accessToken ?: "",
        refreshToken = refreshToken ?: ""
    )