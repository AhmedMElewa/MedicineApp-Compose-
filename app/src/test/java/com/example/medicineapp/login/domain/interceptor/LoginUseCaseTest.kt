package com.example.medicineapp.login.domain.interceptor

import com.example.medicineapp.login.domain.entity.RequiredFieldsException
import com.example.medicineapp.login.domain.repository.UserRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class LoginUseCaseTest {

    private val userRepository: UserRepository = mock()
    private val loginUseCase = LoginUseCase(userRepository)

    @Test
    fun `login with valid credentials should return success`() = runBlocking {
        // Given
        val params = LoginParams("valid@email.com", "validPassword")
        whenever(userRepository.login(params.email, params.password)).thenReturn(true)

        // When
        val result = loginUseCase(params).isSuccess

        // Then
        assertEquals(true, result)
    }

    @Test
    fun `login with empty email should return failure`() = runBlocking {
        // Given
        val params = LoginParams("", "validPassword")
        whenever(userRepository.login(params.email, params.password)).thenReturn(false)

        // When
        val result = loginUseCase(params).isFailure

        // Then
        assertEquals(true, result)
    }

    @Test
    fun `login with empty password parameters should return failure`() = runBlocking {
        // Given
        val params = LoginParams("validEmail", "")
        whenever(userRepository.login(params.email, params.password)).thenReturn(false)

        // When
        val result = loginUseCase(params).isFailure

        // Then
        assertEquals(true, result)
    }
}