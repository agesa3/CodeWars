package com.agesadev.codewarstwo.data.local.converters

import androidx.room.TypeConverter


class ListStringConverter {
    @TypeConverter
    fun listStringToString(list: List<String>?): String {
        return list?.joinToString(separator = SEPARATOR) ?: ""
    }

    @TypeConverter
    fun stringToListString(str: String?): List<String> {
        return str?.split(SEPARATOR) ?: emptyList()
    }

    companion object {
        private const val SEPARATOR = ","
    }
}