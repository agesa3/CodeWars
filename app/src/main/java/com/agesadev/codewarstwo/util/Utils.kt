package com.agesadev.codewarstwo.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

object Utils {
    const val DB_NAME = "codewars_db"
    const val BASE_URL = "https://www.codewars.com/api/v1/"
    const val TEST_USERNAME = "matt c"
    const val CODEWARS_STARTING_INDEX = 0
    const val PARAM_CHALLENGE_ID = "challengeId"
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
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

