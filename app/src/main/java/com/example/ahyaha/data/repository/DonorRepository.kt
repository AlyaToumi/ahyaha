package com.example.ahyaha.data.repository

import com.example.ahyaha.data.model.Donor
import kotlinx.coroutines.flow.Flow

interface DonorRepository {

    abstract val donorDao: Any

    suspend fun addDonor(donor: Donor)

    suspend fun updateDonor(donor: Donor)

    suspend fun deleteDonorById(id: String)

    suspend fun getDonorById(id: String): Donor?

    fun getAllDonors(): Flow<List<Donor>>
}
