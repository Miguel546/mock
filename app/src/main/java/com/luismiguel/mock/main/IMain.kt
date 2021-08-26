package com.luismiguel.mock.main

import com.luismiguel.mock.bean.DataClassMiRespuesta
import retrofit2.Response

interface IMain {
    suspend fun llamada(): Response<Any>
}