package com.agesadev.codewarstwo.util

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    const val DB_NAME = "codewars_db"
    const val BASE_URL = "https://www.codewars.com/api/v1/"
    const val TEST_USERNAME = "g964"
    const val CODEWARS_STARTING_INDEX = 0
    const val PARAM_CHALLENGE_ID = "challengeId"
    const val CHALLENGE_DETAILS="challenge_details"
    const val COMPLETED_CHALLENGES="completed_challenges"
    const val REMOTE_KEYS_TABLE="challenge_remote_keys"
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

object TestTags {
    const val LAZY_COLUMN_COMPLETED = "lazyColumnCompleted"
    const val LIST_CARD_ITEM= "listCardItem"
    const val CHALLENGE_NAME = "challengeName"
    const val DATE_COMPLETED = "dateCompleted"
    const val MY_SPACER = "mySpacerTag"
    const val MY_TEXT= "myTextTag"
}
