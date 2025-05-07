package com.example.ahyaha.data.local

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    // تحويل Long إلى Date
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }  // إذا كانت القيمة غير فارغة، نقوم بإنشاء كائن Date
    }

    // تحويل Date إلى Long
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time  // إذا كانت القيمة غير فارغة، نقوم بإرجاع الوقت كـ timestamp (Long)
    }
}
