package com.example.medicineapp.core.di

import android.app.Application
import com.example.medicineapp.medicine_list.data.ds.local.roomdb.MedicineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = MedicineDatabase.getDatabase(application)

    @Singleton
    @Provides
    fun provideMedicineDao(database: MedicineDatabase) =
        database.getMedicineDao()
}