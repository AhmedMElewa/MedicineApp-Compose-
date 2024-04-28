package com.example.medicineapp.login.data.repository

import com.example.medicineapp.login.data.model.Credentials
import com.example.medicineapp.login.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(): UserRepository {
    override fun login(email: String, password: String): Boolean {
        return Credentials(email, password).isNotEmpty()
    }
}