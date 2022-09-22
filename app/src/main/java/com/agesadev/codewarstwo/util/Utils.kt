package com.agesadev.codewarstwo.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    const val DB_NAME = "codewars_db"
    const val BASE_URL = "https://www.codewars.com/api/v1/"
    const val TEST_USERNAME = "g964"
    const val CODEWARS_STARTING_INDEX = 0
    const val PARAM_CHALLENGE_ID = "challengeId"
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}


fun dateUtilConverter(inputDate: String): String {
    val currentDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK)
    val date = currentDateFormat.parse(inputDate)
    val newDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
    if (date != null) {
        return newDateFormat.format(date)
    }
    return ""
}


////use kotlin flows
//object GetOperation {
//    fun <T, A> performGetOperation(
//        databaseQuery: () -> Flow<T>,
//        networkCall: suspend () -> Resource<A>,
//        saveCallResult: suspend (A) -> Unit
//    ): Flow<Resource<T>> =
//        flow {
//            emit(Resource.Loading())
//            val source = databaseQuery.invoke().map { Resource.Success(it) }
//            emitAll(source)
//            val responseStatus = networkCall.invoke()
//            if (responseStatus is Resource.Success) {
//                responseStatus.data?.let { saveCallResult(it) }
//            } else if (responseStatus is Resource.Error) {
//                emit(Resource.Error(responseStatus.message!!))
//                emitAll(source)
//            }
//        }.flowOn(Dispatchers.IO)
//}

