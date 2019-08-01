package com.brianvega.ucm_app.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    private const val DATE_FORMAT = "dd/MM/yyyy"

    fun dateToString(date: Date): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        return dateFormat.format(date)
    }

    fun stringToDate(date: String): Date {
        return SimpleDateFormat("dd/MM/yyyy").parse(date)
    }

}