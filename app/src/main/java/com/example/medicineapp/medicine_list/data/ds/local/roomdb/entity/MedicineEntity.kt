package com.example.medicineapp.medicine_list.data.ds.local.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.medicineapp.medicine_list.domain.entity.Medicine

@Entity(tableName = MedicineEntity.TABLE_NAME)
data class MedicineEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val dose: String,
    val strength: String
){
    fun toMedicine(): Medicine {
        return Medicine(
            name = name,
            dose = dose,
            strength = strength,
        )
    }

    companion object {
        const val TABLE_NAME = "Medicine"
    }
}
