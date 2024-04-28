package com.example.medicineapp.login.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicineapp.R
import com.example.medicineapp.core.data.ds.SharedPrefsManager
import com.example.medicineapp.core.data.ds.SharedPrefsManager.Companion.USERNAME
import com.example.medicineapp.login.data.model.Credentials
import com.example.medicineapp.login.domain.interceptor.LoginParams
import com.example.medicineapp.login.domain.interceptor.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val myPreference: SharedPrefsManager
) :
    ViewModel() {

    var credentials by mutableStateOf(Credentials())



    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading

    private val _error = MutableSharedFlow<Boolean>()
    val error: SharedFlow<Boolean>
        get() = _error

    private val _userData = MutableSharedFlow<Credentials>()
    val userData: SharedFlow<Credentials>
        get() = _userData

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            delay(1000)
            try {
                loginUseCase.invoke(LoginParams(credentials.username, credentials.password)).fold({
                    if (it){
                        _userData.emit(credentials)
                        updateError(true)
                    }else{
                        updateError(false)
                    }
                    _isLoading.emit(false)
                }, {
                   updateError(false)
                })
            }  catch (e: Exception) {
                updateError(false)
            }

        }
    }

    private fun updateError(message: Boolean) {
        viewModelScope.launch {
            _error.emit(message)
            _isLoading.emit(false)
        }
    }

    fun saveUser(){
        myPreference.putString(USERNAME, credentials.username)
    }
}