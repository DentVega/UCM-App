package com.brianvega.ucm_app.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.brianvega.ucm_app.Constants
import com.brianvega.ucm_app.R

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity(), Constants {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun showToast(resMessageId: Int) {
        showToast(resources.getString(resMessageId))
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showProgressBar(progressBar: ProgressBar) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar(progressBar: ProgressBar) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        progressBar.visibility = View.GONE
    }

    fun loadFragment(fragment: Fragment, @IdRes containerView: Int) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(containerView, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun showCustomToast(resMessageId: Int) {
        showCustomToast(resources.getString(resMessageId))
    }

    @SuppressLint("InflateParams")
    fun showCustomToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        val view = layoutInflater.inflate(R.layout.toast_custom, null)
        (view.findViewById<View>(R.id.txt_message) as TextView).text = message
        toast.view = view
        toast.show()
    }

}