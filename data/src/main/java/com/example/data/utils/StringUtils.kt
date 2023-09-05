package com.example.data.utils

import java.text.SimpleDateFormat
import java.util.Date

fun String.transformToDate(format: String = "yyyy-MM-dd"): Date? {
    val dateFormat = SimpleDateFormat(format)
    try {
        return dateFormat.parse(this)
    } catch ( e: Exception ){
        e.printStackTrace()
    }
    return null
}