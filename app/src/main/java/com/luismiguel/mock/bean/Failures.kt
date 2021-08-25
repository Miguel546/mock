package com.luismiguel.mock.bean

import com.luismiguel.mock.bean.Result

data class Failures(val code: Int? = null, val error: ErrorResponse? = null) : Result<Nothing>()