package com.example.challenge.data.repository

import com.example.challenge.data.common.HandleResponse
import com.example.challenge.data.common.Resource
import com.example.challenge.data.mapper.asResource
import com.example.challenge.data.mapper.toDomain
import com.example.challenge.data.service.ConnectionsService
import com.example.challenge.domain.model.GetConnection
import com.example.challenge.domain.repository.connection.ConnectionsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConnectionsRepositoryImpl @Inject constructor(
    private val connectionsService: ConnectionsService,
    private val handleResponse: HandleResponse,
) : ConnectionsRepository {

    override suspend fun getConnections(): Flow<Resource<List<GetConnection>>> {
        return handleResponse.safeApiCall {
            connectionsService.getConnections()
        }.asResource {it ->
            it.map {
                it.toDomain()
            }
        }
    }
}