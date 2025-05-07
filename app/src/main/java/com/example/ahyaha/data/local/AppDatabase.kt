package com.example.ahyaha.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DonorEntity::class],  // إضافة الكائنات (entities) التي سيتم تخزينها في قاعدة البيانات
    version = 1,  // رقم النسخة
    exportSchema = false  // إذا كنت لا تحتاج لتصدير مخطط قاعدة البيانات
)
@TypeConverters(Converters::class)  // إضافة المحولات هنا
abstract class AppDatabase : RoomDatabase() {
    abstract fun donorDao(): DonorDao  // تحديد الـ DAO الخاص بك
}

