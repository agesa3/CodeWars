package com.agesadev.codewarstwo.data.local.converters

import androidx.room.TypeConverter

class LanguagesConverter {
    @TypeConverter
    fun toStrings(completedLanguages: List<String>): String {
        val completedLanguagesString = ""
        return if (completedLanguages.isEmpty()) {
            completedLanguagesString
        } else {
            completedLanguages.forEach { completedLanguages ->
                completedLanguagesString.plus("$completedLanguages,")
            }
            completedLanguagesString
        }
    }

    @TypeConverter
    fun toList(completedLanguageString: String): List<String> {
        val completedLanguages = mutableListOf<String>()
        return if (completedLanguageString.isEmpty()) {
            completedLanguages
        } else {
            val languages = completedLanguageString.split(",")
            languages.forEach { language ->
                completedLanguages.add(language)
            }
            completedLanguages
        }
    }
}