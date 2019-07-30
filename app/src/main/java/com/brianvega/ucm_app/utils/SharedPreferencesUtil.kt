package com.brianvega.ucm_app.utils

import android.app.Activity
import android.content.Context
import com.brianvega.ucm_app.Constants

object SharedPreferencesUtil {

    fun isFirstTime(activity: Activity): Boolean {
        val sharedPreferences = activity.getSharedPreferences(Constants.SHARED_PREFERENCES_FIRST_TIME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(Constants.FIRST_TIME_ID, false)
    }

    fun setFirstTime(activity: Activity, isFirstTime: Boolean) {
        val editor = activity.getSharedPreferences(Constants.SHARED_PREFERENCES_FIRST_TIME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(Constants.FIRST_TIME_ID, isFirstTime)
        editor.apply()
    }

}