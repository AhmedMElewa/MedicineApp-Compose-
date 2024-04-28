package com.example.medicineapp.login.domain.repository

interface UserRepository {
    fun login(email: String, password: String): Boolean
}