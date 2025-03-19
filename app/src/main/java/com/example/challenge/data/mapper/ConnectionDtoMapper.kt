package com.example.challenge.data.mapper

import com.example.challenge.data.model.ConnectionDto
import com.example.challenge.domain.model.GetConnection

fun ConnectionDto.toDomain() =
    GetConnection(
        avatar = avatar ?: "",
        email = email,
        id = id,
        fullName = firstName.plus(" ").plus(lastName)
    )