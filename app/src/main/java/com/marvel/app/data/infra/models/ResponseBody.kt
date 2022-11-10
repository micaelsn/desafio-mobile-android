package com.marvel.app.data.infra.models

data class ResponseBody (
    val code: Int?,
    val status: String?,
    val etag: String?,
    val data: Data
)