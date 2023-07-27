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


    fun getAuthToken(context: Context): String? {
        return getAuthToken(context, TOKEN)
    }


    fun saveSPId(context: Context, id: String) {
        saveSPIdToSharedPreferences(context, id)
    }

    fun getSPId(context: Context): String? {
        return getSpId(context)
    }

    private fun saveSPIdToSharedPreferences(context: Context, value: String) {

        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(ID, value)
        editor.apply()

    }


    private fun saveAuthTokenToSharedPreferences(context: Context, value: String) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(TOKEN, value)
        editor.apply()
    }

    private fun getAuthToken(context: Context, key: String): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getString(this.TOKEN, null)
    }

    private fun getSpId(context: Context): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return prefs.getString(this.ID, null)
    }

    fun clearData(context: Context) {
        val editor =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
                .edit()
        editor.clear()
        editor.apply()
    }

}