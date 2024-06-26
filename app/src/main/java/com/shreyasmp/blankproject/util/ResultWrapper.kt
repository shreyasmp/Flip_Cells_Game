package com.shreyasmp.blankproject.util

sealed class ResultWrapper<out T : Any> {
    data class SUCCESS<out T : Any>(val value: T?) : ResultWrapper<T>()
    data class FAILURE(
        val code: String?
    ) : ResultWrapper<Nothing>()

    val success: Boolean
        get() = this is SUCCESS
}