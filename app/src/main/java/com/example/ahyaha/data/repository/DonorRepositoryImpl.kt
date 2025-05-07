package com.example.ahyaha.data.repository
import com.example.ahyaha.data.local.DonorDao
import com.example.ahyaha.data.local.toEntity
import com.example.ahyaha.data.local.toDomain

import com.example.ahyaha.data.model.Donor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import java.util.Date

class DonorRepositoryImpl(override val donorDao: DonorDao
) : DonorRepository {


    private val _donors = mutableListOf(
        Donor(
            id = "1",
            name = "John Doe",
            email = "john.doe@example.com",
            phoneNumber = "1234567890",
            profilePicture = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "A",
            Rh = "+",
            location = "New York",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Donor(
            id = "2",
            name = "Jane Smith",
            email = "jane.smith@example.com",
            phoneNumber = "0987654321",
            profilePicture = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "B",
            Rh = "-",
            location = "Los Angeles",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Donor(
            id = "3",
            name = "Michael ",
            email = "michael.johnson@example.com",
            phoneNumber = "5555555555",
            profilePicture = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "O",
            Rh = "+",
            location = "Chicago",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Donor(
            id = "4",
            name = "Emily Davis",
            email = "emily.davis@example.com",
            phoneNumber = "4444444444",
            profilePicture = "https://images.unsplash.com/photo-1491349174775-aaafddd81942?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "AB",
            Rh = "+",
            location = "Houston",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Donor(
            id = "5",
            name = "David Wilson",
            email = "david.wilson@example.com",
            phoneNumber = "3333333333",
            profilePicture = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "A",
            Rh = "-",
            location = "Phoenix",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Donor(
            id = "6",
            name = "okba ",
            email = "michael.johnson@example.com",
            phoneNumber = "5555555555",
            profilePicture = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            bloodGroup = "O",
            Rh = "+",
            location = "Chicago",
            lastDonationDate = Date(),
            createdAt = Date(),
            updatedAt = Date()
        ),

        )

    private val _donorFlow = MutableSharedFlow<List<Donor>>(replay = 1)

    init {
        _donorFlow.tryEmit(_donors.toList())
    }


    override suspend fun addDonor(donor: Donor) {
        donorDao.insertDonor(donor.toEntity())
    }

    override suspend fun updateDonor(donor: Donor) {
        donorDao.updateDonor(donor.toEntity())
    }

    override suspend fun deleteDonorById(id: String) {
        donorDao.deleteDonorById(id)
    }

    override suspend fun getDonorById(id: String): Donor? {
        return donorDao.getDonorById(id)?.toDomain()
    }

    override fun getAllDonors(): Flow<List<Donor>> {
        return donorDao.getAllDonors().map { list ->
            list.map { it.toDomain() }
        }
    }
}




