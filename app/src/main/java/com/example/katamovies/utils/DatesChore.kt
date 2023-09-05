package com.example.katamovies.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date?.ToFormat(format: String = "yyyy-MM-dd"): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(this)
}