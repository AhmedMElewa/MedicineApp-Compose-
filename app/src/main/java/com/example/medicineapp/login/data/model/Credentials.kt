package com.example.medicineapp.login.data.model

data class Credentials(
    var username: String = "",
    var password: String = "",
){
    fun isNotEmpty(): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}
