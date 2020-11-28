package com.agromall.remote.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import com.google.gson.JsonArray

fun JsonArray.getFormattedAddress():String{
    for (element in this){
        return element.asJsonObject.get("formatted_address").asString
    }
    return ""
}

fun JsonArray.getCity():String{
    for (element in this){
        val cityName = element.asJsonObject.get("long_name").asString

        val type = element.asJsonObject.get("types").asJsonArray
        type.forEach {
            if(it.asString == "administrative_area_level_2")
                return cityName
        }
    }
    return ""
}

fun JsonArray.getState():String {
    for (element in this){
        val stateName = element.asJsonObject.get("long_name").asString

        val type = element.asJsonObject.get("types").asJsonArray
        type.forEach {
            if(it.asString == "administrative_area_level_1")
                return stateName
        }
    }
    return ""
}

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

fun String.getClusterStatus(): String {
    if(this.toLowerCase().startsWith("com")){
        return "AS"
    } else if(this.toLowerCase().startsWith("in")) {
        return "PD"
    } else return "UA"
}