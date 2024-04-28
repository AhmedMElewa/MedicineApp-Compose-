package com.example.medicineapp.medicine_list.presentation.viewmodel

import android.net.http.NetworkException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicineapp.core.data.ds.SharedPrefsManager
import com.example.medicineapp.core.data.ds.SharedPrefsManager.Companion.USERNAME
import com.example.medicineapp.medicine_list.domain.interceptor.GetMedicineListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.medicineapp.R
import com.example.medicineapp.core.domain.exceptions.NoInternetException
import com.example.medicineapp.core.domain.exceptions.UnknownException
import com.example.medicineapp.medicine_list.domain.entity.Medicine


@HiltViewModel
class MedicineViewModel @Inject constructor(
    private val myPreference: SharedPrefsManager,
    private val getMedicineListUseCase: GetMedicineListUseCase
) :
    ViewModel() {



    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading

    private val _error = MutableSharedFlow<Any>()
    val error: SharedFlow<Any>
        get() = _error

    private val _userName = MutableStateFlow<String>("")
    val userName: StateFlow<String>
        get() = _userName

    private val _medicineList = MutableStateFlow<List<Medicine>>(emptyList())
    val medicineList: StateFlow<List<Medicine>>
        get() = _medicineList

    private val _selectedMedicine = MutableStateFlow<Medicine?>(null)
    val selectedMedicine: StateFlow<Medicine?>
        get() = _selectedMedicine

    fun getLoggedInUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _userName.emit(myPreference.getString(USERNAME, "") ?: "")
        }
    }


    fun getMedicineList() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            getMedicineListUseCase.invoke(Unit)
                .fold({
                    if (!it.isNullOrEmpty()) {
                        _isLoading.emit(false)
                        _medicineList.emit(it)
                    } else {
                        updateError((R.string.no_data_found))
                    }
                }, { it.handleError() })
        }
    }

    fun onMedicineSelect(medicineEntity: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedMedicine.emit(medicineEntity)
        }
    }

    private fun updateError(message: Any) {
        viewModelScope.launch {
            _error.emit(message)
            _isLoading.emit(false)
        }
    }


    private fun Throwable.handleError() {
        when (this@handleError) {
            is NoInternetException -> updateError(R.string.no_internet)
            is UnknownException -> updateError(R.string.unknown_error)
            else -> updateError((R.string.generic_error))
        }
    }
}