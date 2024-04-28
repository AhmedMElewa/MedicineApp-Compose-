package com.example.medicineapp.login.di

import com.example.medicineapp.login.data.repository.UserRepositoryImpl
import com.example.medicineapp.login.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class  LoginModule {
    @Binds
    abstract fun bindRepository(repository: UserRepositoryImpl): UserRepository

}