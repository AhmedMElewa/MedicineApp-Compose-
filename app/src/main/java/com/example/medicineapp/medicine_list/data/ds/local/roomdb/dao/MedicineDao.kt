package com.example.medicineapp.medicine_list.data.ds.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.medicineapp.medicine_list.data.ds.local.roomdb.entity.MedicineEntity

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicineList(medicineList: List<MedicineEntity>)

    @Query("SELECT * FROM ${MedicineEntity.TABLE_NAME}")
    suspend fun getMedicineList(): List<MedicineEntity>

    @Query("DELETE FROM ${MedicineEntity.TABLE_NAME}")
    suspend fun deleteAll()
}