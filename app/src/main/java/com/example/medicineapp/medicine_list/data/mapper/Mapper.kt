package com.example.medicineapp.medicine_list.data.mapper

import com.example.medicineapp.medicine_list.data.ds.local.roomdb.entity.MedicineEntity
import com.example.medicineapp.medicine_list.data.ds.remote.dto.MedicineDto

fun MedicineDto.mapToEntity(): List<MedicineEntity> {
    val list = ArrayList<MedicineEntity>()
    var idCount = 0
    list.addAll(this.problems.flatMap { it.Diabetes.flatMap { it.medications.flatMap { it.medicationsClasses.flatMap { it.className.flatMap { it.associatedDrug.map { MedicineEntity(
        id = ++idCount, name = it?.name ?: "", dose = it?.dose ?: "", strength = it?.strength ?: ""
    ) } } } } } } ?: emptyList())
    list.addAll(this.problems.flatMap { it.Diabetes.flatMap { it.medications.flatMap { it.medicationsClasses.flatMap { it.className2.flatMap { it.associatedDrug.map { MedicineEntity(
        id = ++idCount, name = it?.name ?: "", dose = it?.dose ?: "", strength = it?.strength ?: ""
    ) } } } } } } ?: emptyList())
    list.addAll(this.problems.flatMap { it.Diabetes.flatMap { it.medications.flatMap { it.medicationsClasses.flatMap { it.className.flatMap { it.associatedDrug2.map { MedicineEntity(
        id = ++idCount, name = it?.name ?: "", dose = it?.dose ?: "", strength = it?.strength ?: ""
    ) } } } } } } ?: emptyList())
    list.addAll(this.problems.flatMap { it.Diabetes.flatMap { it.medications.flatMap { it.medicationsClasses.flatMap { it.className2.flatMap { it.associatedDrug2.map { MedicineEntity(
        id = ++idCount, name = it?.name ?: "", dose = it?.dose ?: "", strength = it?.strength ?: ""
    ) } } } } } } ?: emptyList())
    return list
}
