package com.example.ahyaha.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "donors")
data class DonorEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val profilePicture: String?,
    val bloodGroup: String,
    val rh: String,
    val location: String,
    val lastDonationDate: Long?,  // نستخدم timestamp
    val createdAt: Long,
    val updatedAt: Long
)

