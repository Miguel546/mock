package com.luismiguel.mock.main

interface IMain {
    suspend fun llamada(): Result<Any>
}