package com.example.medicineapp.medicine_list.domain.repository

import com.example.medicineapp.medicine_list.domain.entity.Medicine

interface MedicineRepository {

    suspend fun getMedicineList(
    ): Result<List<Medicine>>
}