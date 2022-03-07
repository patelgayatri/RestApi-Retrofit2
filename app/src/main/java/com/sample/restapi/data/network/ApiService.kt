package com.sample.restapi.data.network

import com.sample.restapi.data.models.TvShowItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiService @Inject constructor(private val api: TvShowApi) {

    suspend fun getTvShow(): Flow<Result<List<TvShowItem>>> {
        return flow {
            emit(Result.success(api.getTvShows()))
        }.catch {
            emit(Result.failure(RuntimeException(it.message ?: "Error")))
        }
    }
}