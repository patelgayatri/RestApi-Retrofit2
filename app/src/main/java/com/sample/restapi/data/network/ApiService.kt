package com.sample.restapi.data.network

import com.sample.restapi.data.models.TvShowResponse
import com.sample.restapi.utils.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT)
    suspend fun getTvShows():Response<TvShowResponse>

}