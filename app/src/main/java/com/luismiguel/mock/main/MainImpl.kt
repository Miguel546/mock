package com.luismiguel.mock.main

import com.luismiguel.mock.api.IApiService
import javax.inject.Inject

class MainImpl @Inject constructor(private val apiService: IApiService): IMain {
    override suspend fun llamada(): Result<Any> {
        return apiService.mock()
    }
}