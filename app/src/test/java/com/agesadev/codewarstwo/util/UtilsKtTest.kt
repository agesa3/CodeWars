package com.agesadev.codewarstwo.util

import org.junit.Assert.*
import org.junit.Test

class UtilsKtTest {

    @Test
    fun testThatDateUtilConverterReturnsCorrectDate() {
        val inputDate = "2020-05-01T00:00:00.000Z"
        val expectedDate = "01/05/2020"
        val actualDate = dateUtilConverter(inputDate)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testThatDateUtilConverterReturnsEmptyStringWhenInputDateIsInvalid() {
        val inputDate = "2020-05-01T00:00:00.000"
        val expectedDate = ""
        val actualDate = dateUtilConverter(inputDate)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testThatDateUtilConverterReturnsEmptyStringWhenInputDateIsEmpty() {
        val inputDate = ""
        val expectedDate = ""
        val actualDate = dateUtilConverter(inputDate)
        assertEquals(expectedDate, actualDate)
    }

}