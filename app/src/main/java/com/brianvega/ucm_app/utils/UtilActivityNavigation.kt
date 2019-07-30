package com.brianvega.ucm_app.utils

import android.app.Activity
import android.content.Intent

object UtilActivityNavigation {

    fun goToActivity(activity: Activity, nextActivity: Class<*>, addExtras: (() -> Unit)?, finishedActivity: Boolean) {
        val intent = Intent(activity, nextActivity)
        if (addExtras != null)
            addExtras()

        activity.startActivity(intent)
        if (finishedActivity)
            activity.finish()
    }

}