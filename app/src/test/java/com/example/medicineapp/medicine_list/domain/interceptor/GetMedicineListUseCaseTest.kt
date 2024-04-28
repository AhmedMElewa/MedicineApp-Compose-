package com.example.medicineapp.medicine_list.domain.interceptor

import com.example.medicineapp.core.domain.exceptions.NoInternetException
import com.example.medicineapp.medicine_list.domain.entity.Medicine
import com.example.medicineapp.medicine_list.domain.repository.MedicineRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetMedicineListUseCaseTest {

    private val repository: MedicineRepository = mockk()
    private val useCase = GetMedicineListUseCase(repository)

    @Test
    fun `get medicine list successfully`() = runBlocking {
        // Given
        val expectedMedicineList = listOf(
            Medicine(name = "Medicine 1", dose = "1", strength = "500"),
            Medicine(name = "Medicine 2", dose = "1", strength = "300"),
        )

        coEvery { repository.getMedicineList() } returns Result.success(expectedMedicineList)

        // When
        val result = useCase(Unit)

        // Then
        assertEquals(Result.success(expectedMedicineList), result)
    }

    @Test(expected = NoInternetException::class)
    fun `get medicine list with no internet connection should throw custom exception`() = runBlocking {
        // Given
        val expectedException = NoInternetException
        coEvery { repository.getMedicineList() } throws expectedException

        // When
        val result = useCase(Unit)

        // Then
        assertEquals(Result.failure<Exception>(expectedException), result)
    }


}