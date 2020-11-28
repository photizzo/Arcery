package com.agromall.data

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.getFormattedDate(returnFormat: String, currentFormat: String): String {
    val format = SimpleDateFormat(currentFormat)
    try {
        val date = format.parse(this)
        val df = SimpleDateFormat(returnFormat)
        val dateString: String = df.format(date)
        return dateString
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val df = SimpleDateFormat(returnFormat)
    val date: String = df.format(Calendar.getInstance().time)
    return date
}