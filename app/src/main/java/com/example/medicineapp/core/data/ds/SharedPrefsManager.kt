package com.example.medicineapp.core.data.ds

import android.app.Activity
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefsManager @Inject constructor(@ApplicationContext context: Context) {

    private val preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    companion object {
        const val PREFERENCES = "Medicine"
        const val USERNAME = "USERNAME"

        @Synchronized
        fun newInstance(context: Activity) = SharedPrefsManager(context)
    }

    fun putString(key: String, value: String?) = preferences.edit().putString(key,value).apply()

    fun putBoolean(key: String, value: Boolean) = preferences.edit().putBoolean(key, value).apply()

    fun putInt(key: String, value: Int) = preferences.edit().putInt(key, value).apply()

    fun getString(key: String, defValue: String?) = preferences.getString(key, defValue)

    fun getBoolean(key: String, defValue: Boolean) = preferences.getBoolean(key, defValue)

    fun getInt(key: String, defValue: Int) = preferences.getInt(key, defValue)
}
