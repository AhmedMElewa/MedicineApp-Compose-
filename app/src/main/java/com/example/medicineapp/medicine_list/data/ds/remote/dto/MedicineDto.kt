package com.example.medicineapp.medicine_list.data.ds.remote.dto

import com.google.gson.annotations.SerializedName

data class MedicineDto(
    @SerializedName("problems") var problems: ArrayList<Problems> = arrayListOf()
)

data class Problems(
    @SerializedName("Diabetes") var Diabetes: ArrayList<Diabetes> = arrayListOf(),
)

data class Diabetes(
    @SerializedName("medications") var medications: ArrayList<Medications> = arrayListOf(),
    @SerializedName("labs") var labs: ArrayList<Labs> = arrayListOf()
)

data class Medications(
    @SerializedName("medicationsClasses") var medicationsClasses: ArrayList<MedicationsClasses> = arrayListOf()
)

data class Labs(
    @SerializedName("missing_field") var missingField: String? = null
)

data class MedicationsClasses(
    @SerializedName("className") var className: ArrayList<ClassName> = arrayListOf(),
    @SerializedName("className2") var className2: ArrayList<ClassName2> = arrayListOf()
)

data class ClassName(
    @SerializedName("associatedDrug") var associatedDrug: ArrayList<AssociatedDrug> = arrayListOf(),
    @SerializedName("associatedDrug#2") var associatedDrug2: ArrayList<AssociatedDrug2> = arrayListOf()
)

data class ClassName2(
    @SerializedName("associatedDrug") var associatedDrug: ArrayList<AssociatedDrug> = arrayListOf(),
    @SerializedName("associatedDrug#2") var associatedDrug2: ArrayList<AssociatedDrug2> = arrayListOf()
)

data class AssociatedDrug(
    @SerializedName("name") var name: String? = null,
    @SerializedName("dose") var dose: String? = null,
    @SerializedName("strength") var strength: String? = null
)

data class AssociatedDrug2(
    @SerializedName("name") var name: String? = null,
    @SerializedName("dose") var dose: String? = null,
    @SerializedName("strength") var strength: String? = null
)
