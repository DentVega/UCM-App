package com.brianvega.ucm_app.utils

import android.app.Activity
import android.content.Intent

object UtilActivityNavigation {

    fun goToActivity(activity: Activity, nextActivity: Class<*>, addExtras: (Intent) -> Unit, finishedActivity: Boolean) {
        val intent = Intent(activity, nextActivity)
        addExtras(intent)
        activity.startActivity(intent)
        if (finishedActivity)
            activity.finish()
    }

    fun goToActivityExtraId(activity: Activity, nextActivity: Class<*>, id: Long, finishedActivity: Boolean) {
        val intent = Intent(activity, nextActivity)
        intent.putExtra("id", id)
        activity.startActivity(intent)
        if (finishedActivity)
            activity.finish()
    }

}