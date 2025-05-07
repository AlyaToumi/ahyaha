package com.example.ahyaha.data.remote.datasource

import com.example.ahyaha.data.model.Donor

interface DonorRemoteDataSource {
        suspend fun addDonor(donor: Donor)
        suspend fun updateDonor(donor: Donor)
        suspend fun deleteDonor(id: String)
        suspend fun getAllDonors(): List<Donor>
        suspend fun getDonorById(id: String): Donor?


}