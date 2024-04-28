package com.example.medicineapp.medicine_list.data.repository

import com.example.medicineapp.core.domain.exceptions.NoInternetException
import com.example.medicineapp.core.domain.exceptions.UnknownException
import com.example.medicineapp.medicine_list.data.ds.local.roomdb.dao.MedicineDao
import com.example.medicineapp.medicine_list.data.ds.remote.MedicineApiService
import com.example.medicineapp.medicine_list.data.ds.remote.dto.MedicineDto
import com.example.medicineapp.medicine_list.data.mapper.mapToEntity
import com.example.medicineapp.medicine_list.domain.entity.Medicine
import com.example.medicineapp.medicine_list.domain.repository.MedicineRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MedicineRepositoryImpl @Inject constructor(
    private val medicineApiService: MedicineApiService,
    private val medicineDao: MedicineDao
) : MedicineRepository {

    override suspend fun getMedicineList(): Result<List<Medicine>> {
        try {
            fetchAndInsertMedicine(medicineApiService, medicineDao)
        } catch (e: HttpException) {
            return  Result.failure(
                UnknownException
            )

        } catch (e: IOException) {
            return Result.failure(
                NoInternetException
            )
        }
        // single source of truth we will emit data from db only and not directly from remote
        return Result.success(getMedicineListFromDb(medicineDao))
    }

    private suspend fun fetchAndInsertMedicine(
        medicineApiService: MedicineApiService,
        medicineDao: MedicineDao
    ) {
        val remoteMedicineList = medicineApiService.getMedicineList()
        val body: MedicineDto? = remoteMedicineList.body()
        body?.let {
            medicineDao.insertMedicineList(it.mapToEntity())
        }
    }

    private suspend fun getMedicineListFromDb(medicineDao: MedicineDao): List<Medicine> {
        return medicineDao.getMedicineList().map { it.toMedicine() }
    }
}