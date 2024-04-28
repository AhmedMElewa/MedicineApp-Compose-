package com.example.medicineapp.medicine_list.domain.interceptor

import com.example.medicineapp.base.BaseUseCase
import com.example.medicineapp.medicine_list.domain.entity.Medicine
import com.example.medicineapp.medicine_list.domain.repository.MedicineRepository
import javax.inject.Inject

class GetMedicineListUseCase @Inject constructor(private val repository: MedicineRepository) :
    BaseUseCase<Unit, Result<List<Medicine>>> {
    override suspend fun invoke(params: Unit?): Result<List<Medicine>> {
        return repository.getMedicineList().fold({
            Result.success(it)
        }, {
            Result.failure(it)
        })
    }
}