package com.brianvega.ucm_app.models.converters

import androidx.room.TypeConverter
import java.util.*

class ConvertersDate {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}