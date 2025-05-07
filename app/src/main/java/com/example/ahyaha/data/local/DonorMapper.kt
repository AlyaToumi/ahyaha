package com.example.ahyaha.data.local


import com.example.ahyaha.data.model.Donor
import java.util.Date

fun DonorEntity.toDomain(): Donor = Donor(
    id = id,
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    profilePicture = profilePicture,
    bloodGroup = bloodGroup,
    Rh = rh,
    location = location,
    lastDonationDate = lastDonationDate?.let { Date(it) },
    createdAt = Date(createdAt),
    updatedAt = Date(updatedAt)
)

fun Donor.toEntity(): DonorEntity = DonorEntity(
    id = id,
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    profilePicture = profilePicture,
    bloodGroup = bloodGroup,
    rh = Rh,
    location = location,
    lastDonationDate = lastDonationDate?.time,
    createdAt = createdAt.time,
    updatedAt = updatedAt.time
)

