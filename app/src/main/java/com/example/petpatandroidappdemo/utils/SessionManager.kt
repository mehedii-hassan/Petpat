package com.example.petpatandroidappdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.petpatandroidappdemo.R

object SessionManager {

    private const val TOKEN = "token"
    private const val ID = "id"

    fun saveAuthToken(context: Context, token: String) {
        saveAuthTokenToSharedPreferences(context, token)
    }

    private fun saveAuthTokenToSharedPreferences(context: Context, token: String) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }


    fun getAuthToken(context: Context): String? {
        return getAuthTokenFromSharedPreferences(context)
    }

    private fun getAuthTokenFromSharedPreferences(context: Context): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getString(TOKEN, null)
    }

    fun saveSPId(context: Context, id: Int) {
        saveSPIdToSharedPreferences(context, id)
    }

    fun getSPId(context: Context): Int {
        return getSpIdToSharedPreferences(context)
    }

    private fun saveSPIdToSharedPreferences(context: Context, value: Int) {

        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt(ID, value)
        editor.apply()

    }


    private fun getSpIdToSharedPreferences(context: Context): Int {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getInt(this.ID, 0)
    }

    fun clearData(context: Context) {
        val editor =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
                .edit()
        editor.clear()
        editor.apply()
    }

}