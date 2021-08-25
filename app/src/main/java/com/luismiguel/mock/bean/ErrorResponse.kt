package com.luismiguel.mock.bean

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: String?,
    val httpStatus: String?,
    val message: String?,
    val debugMessage: String?
)