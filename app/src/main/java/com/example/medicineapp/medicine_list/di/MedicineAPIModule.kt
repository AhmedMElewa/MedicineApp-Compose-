package com.example.medicineapp.medicine_list.di

import com.example.medicineapp.medicine_list.data.ds.remote.MedicineApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object   MedicineAPIModule {

    @Provides
    fun provideRemoteDataSource(retrofit: Retrofit) =
        retrofit.create(MedicineApiService::class.java)
}