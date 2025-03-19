package com.example.challenge.data.repository

import com.example.challenge.data.common.HandleResponse
import com.example.challenge.data.common.Resource
import com.example.challenge.data.mapper.asResource
import com.example.challenge.data.mapper.toDomain
import com.example.challenge.data.service.LogInService
import com.example.challenge.domain.model.GetToken
import com.example.challenge.domain.repository.log_in.LogInRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogInRepositoryImpl @Inject constructor(
    private val logInService: LogInService,
    private val handleResponse: HandleResponse,
) : LogInRepository {
    override suspend fun logIn(email: String, password: String): Flow<Resource<GetToken>> {
        return handleResponse.safeApiCall {
            logInService.logIn(email = email, password = password)
        }.asResource {
            it.toDomain()
        }
    }
}