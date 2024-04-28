package com.example.medicineapp.medicine_list.data.ds.remote

import com.example.medicineapp.medicine_list.data.ds.remote.dto.MedicineDto
import retrofit2.Response
import retrofit2.http.GET

interface MedicineApiService {

    @GET("v3/e86d5800-3b5e-433e-99be-8513f3e35b1a")
    suspend fun getMedicineList(
    ): Response<MedicineDto>
}