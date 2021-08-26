package com.luismiguel.mock.main

import com.luismiguel.mock.api.IApiService
import com.luismiguel.mock.bean.DataClassMiRespuesta
import retrofit2.Response
import javax.inject.Inject

class MainImpl @Inject constructor(private val apiService: IApiService): IMain {
    override suspend fun llamada(): Response<Any> {
        return apiService.mock()
    }
}