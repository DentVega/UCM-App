package com.brianvega.ucm_app.dialogFragments

import android.widget.Toast
import androidx.fragment.app.DialogFragment

open class BaseDialogFragment: DialogFragment() {

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}