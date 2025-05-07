package com.example.ahyaha.data.local


import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface DonorDao {

    @Query("SELECT * FROM donors")
    fun getAllDonors(): Flow<List<DonorEntity>>

    @Query("SELECT * FROM donors WHERE id = :id")
    suspend fun getDonorById(id: String): DonorEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonor(donor: DonorEntity)

    @Update
    suspend fun updateDonor(donor: DonorEntity)

    @Delete
    suspend fun deleteDonor(donor: DonorEntity)

    @Query("DELETE FROM donors WHERE id = :id")
    suspend fun deleteDonorById(id: String)

    @Query("DELETE FROM donors")
    suspend fun deleteAllDonors()
}

