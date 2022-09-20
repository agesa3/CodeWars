package com.agesadev.codewarstwo.data.local.converters

import androidx.room.TypeConverter

class ListStringConverter {
    @TypeConverter
    fun toStrings(anyListOfString: List<String>): String {
        val someString = ""
        return if (anyListOfString.isEmpty()) {
            someString
        } else {
            anyListOfString.forEach { it ->
                someString.plus("$it,")
            }
            someString
        }
    }

    @TypeConverter
    fun toList(someString: String): List<String> {
        val someList = mutableListOf<String>()
        return if (someString.isEmpty()) {
            someList
        } else {
            val languages = someString.split(",")
            languages.forEach { it ->
                someList.add(it)
            }
            someList
        }
    }

}