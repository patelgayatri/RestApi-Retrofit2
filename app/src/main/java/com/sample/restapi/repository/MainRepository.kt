package com.sample.restapi.repository

import com.sample.restapi.data.models.TvShowResponse
import com.sample.restapi.data.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val api:ApiService) {

    suspend fun getTvShow(): Response<TvShowResponse> {
        return api.getTvShows()
    }
}