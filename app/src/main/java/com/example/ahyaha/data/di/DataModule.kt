package com.example.ahyaha.data.di

import android.content.Context
import androidx.room.Room
import com.example.ahyaha.data.local.AppDatabase
import com.example.ahyaha.data.local.DonorDao
import com.example.ahyaha.data.repository.BloodTypeRepository
import com.example.ahyaha.data.repository.BloodTypeRepositoryImpl
import com.example.ahyaha.data.repository.DonorRepository
import com.example.ahyaha.data.repository.DonorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "ahyaha_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDonorDao(database: AppDatabase): DonorDao {
        return database.donorDao()
    }

    @Provides
    @Singleton
    fun provideDonorRepository(donorDao: DonorDao): DonorRepository {
        return DonorRepositoryImpl(donorDao)
    }

    @Provides
    @Singleton
    fun provideBloodTypeRepository(): BloodTypeRepository {
        return BloodTypeRepositoryImpl()
    }
}
