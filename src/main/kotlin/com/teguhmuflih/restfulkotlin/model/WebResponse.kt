package com.teguhmuflih.restfulkotlin.model

data class WebResponse<T>(
    val code: String,
    val status: String,
    val data: T
)
