package com.example.petpatandroidappdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.petpatandroidappdemo.R

object SessionManager {


    private const val ID = "id"
    private const val PREF_NAME = "PetPatSharedPreferences"
    private const val KEY_ACCESS_TOKEN = "access_token"

    // Initialize SharedPreferences
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // Save the access token to SharedPreferences------------------------
    fun saveAccessToken(context: Context, accessToken: String) {
        saveAccessTokenToSharedPreferences(context, accessToken)
    }

    private fun saveAccessTokenToSharedPreferences(context: Context, accessToken: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(KEY_ACCESS_TOKEN, accessToken)
        editor.apply()

    }

    // Get the access token from SharedPreferences
    fun getAccessToken(context: Context): String? {
        return getSharedPreferences(context).getString(KEY_ACCESS_TOKEN, null)
    }

    // Clear the access token from SharedPreferences
    fun clearAccessToken(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove(KEY_ACCESS_TOKEN)
        editor.apply()
    }

    // Check if the user is logged in based on the presence of the access token
    fun isLoggedIn(context: Context): Boolean {
        return getAccessToken(context) != null
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


}