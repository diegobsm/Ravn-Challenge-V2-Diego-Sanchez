package com.ravn.core.util

data class Response<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Response<T> =
            Response(Status.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T? = null): Response<T> {
            return Response(Status.ERROR, data, msg)
        }
    }
}

enum class Status(val value: String) {
    SUCCESS("success"),
    ERROR("error"),
}