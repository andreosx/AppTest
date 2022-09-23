package com.br.apptest.util

import org.json.JSONObject
import retrofit2.Response

sealed class Output<out Response> {
    data class Success<Response> (val value : Response): Output<Response>()
    data class Failure(val statusCode: Int, val message: String): Output<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): Output<R> {
    if (isSuccessful) {
        val body = body()
        if (body != null) {
            return Output.Success(body)
        }
    }
    val msgError = errorBody()?.string()
    return Output.Failure(code(),JSONObject(msgError).getString(Constants.field_message_error_json) ?: Constants.value_unknown_error)
}
