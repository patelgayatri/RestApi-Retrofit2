package com.sample.restapi.repository

import com.sample.restapi.data.models.TvShowItem
import com.sample.restapi.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getTvShow(): Flow<Result<List<TvShowItem>>> =
        apiService.getTvShow().map {
            if (it.isSuccess)
                Result.success(it.getOrNull()!!)
            else
                Result.failure(it.exceptionOrNull()!!)
        }
}
