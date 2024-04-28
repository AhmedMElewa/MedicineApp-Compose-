package com.example.medicineapp.login.domain.interceptor

import com.example.medicineapp.base.BaseUseCase
import com.example.medicineapp.login.domain.entity.RequiredFieldsException
import com.example.medicineapp.login.domain.repository.UserRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<LoginParams, Result<Boolean>> {
    override suspend fun invoke(params: LoginParams?): Result<Boolean> {
        requireNotNull(params)
        return if (userRepository.login(params.email, params.password)){
            Result.success(true)
        }else{
            Result.failure(RequiredFieldsException)
        }
    }
}

data class LoginParams(val email: String, val password: String)

