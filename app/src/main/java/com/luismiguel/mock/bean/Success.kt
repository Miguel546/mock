package com.luismiguel.mock.bean

import com.luismiguel.mock.bean.Result

data class Success<out T: Any>(val data: T) : Result<T>()