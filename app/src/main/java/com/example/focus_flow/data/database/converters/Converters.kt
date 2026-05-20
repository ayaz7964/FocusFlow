package com.example.focus_flow.data.database.converters

//class Converters {
//}

//package com.focusflow.data.database.converters

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Long? = value

    @TypeConverter
    fun dateToTimestamp(date: Long?): Long? = date
}