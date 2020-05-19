package com.example.tgmuresproblema.data.persistence

import android.content.Context
import kotlin.reflect.KClass

/**
 * Class comment here
 *
 * @author Arnold Baroti
 * @since 05/18/2020
 *
 */
class SharedPrefManager(context: Context) {

    private val sharedPref = context.getSharedPreferences(
        SharedPrefManager::class.java.canonicalName,
        Context.MODE_PRIVATE
    )

    fun putValue(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            commit()
        }
    }

    fun putValue(key: String, value: Boolean) {
        with(sharedPref.edit()) {
            putBoolean(key, value)
            commit()
        }
    }

    fun getString(key: String): String {
        return sharedPref.getString(key, "") ?: ""
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

}