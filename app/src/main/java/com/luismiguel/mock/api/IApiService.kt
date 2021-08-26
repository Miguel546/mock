package com.luismiguel.mock.api

import com.luismiguel.mock.bean.DataClassMiRespuesta
import com.luismiguel.mock.bean.Result2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IApiService {
    @POST("/mock")
    suspend fun mock(): Response<Any>

    @POST("/mock")
    suspend fun mock2(): Response<Result2>
}