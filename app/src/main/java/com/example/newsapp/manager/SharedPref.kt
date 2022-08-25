package com.example.newsapp.manager

import android.content.Context
import android.content.SharedPreferences

class SharedPref(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveFinish(isFinish: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isFinish", isFinish)
        editor.apply()
    }
    fun getFinish(): Boolean {
        return sharedPreferences.getBoolean("isFinish", false)
    }
}