package com.example.medicineapp.medicine_list.di

import com.example.medicineapp.medicine_list.data.repository.MedicineRepositoryImpl
import com.example.medicineapp.medicine_list.domain.repository.MedicineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class  MedicineModule {

    @Binds
    abstract fun bindRepository(repository: MedicineRepositoryImpl): MedicineRepository

}