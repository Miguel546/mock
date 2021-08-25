package com.luismiguel.mock.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IApiService {
    @POST("/mock")
    suspend fun mock(): Result<Any>
}