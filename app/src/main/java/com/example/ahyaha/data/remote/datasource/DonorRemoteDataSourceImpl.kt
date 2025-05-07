package com.example.ahyaha.data.remote.datasource

import com.example.ahyaha.data.model.Donor
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DonorRemoteDataSourceImpl : DonorRemoteDataSource {

    private val firestore = FirebaseFirestore.getInstance()
    private val donorsCollection = firestore.collection("donors")

    override suspend fun addDonor(donor: Donor) {
        donorsCollection.document(donor.id).set(donor).await()
    }

    override suspend fun updateDonor(donor: Donor) {
        donorsCollection.document(donor.id).set(donor).await()
    }

    override suspend fun deleteDonor(id: String) {
        donorsCollection.document(id).delete().await()
    }

    override suspend fun getAllDonors(): List<Donor> {
        val snapshot = donorsCollection.get().await()
        return snapshot.documents.mapNotNull { it.toObject(Donor::class.java) }
    }

    override suspend fun getDonorById(id: String): Donor? {
        val snapshot = donorsCollection.document(id).get().await()
        return snapshot.toObject(Donor::class.java)
    }
}
