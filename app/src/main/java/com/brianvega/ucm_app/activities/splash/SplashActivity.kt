package com.brianvega.ucm_app.activities.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.activities.main.MainActivity
import com.brianvega.ucm_app.utils.UtilActivityNavigation

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadReferences()
        loadData()
    }

    private fun loadReferences() {
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    private fun loadData() {
        if (!viewModel.isFirstTime(this)) {
            viewModel.createDataInitial(this) {
                loadNextActivity()
            }
        } else {
            loadNextActivity()
        }
    }

    private fun loadNextActivity() {
        UtilActivityNavigation.goToActivity(this, MainActivity::class.java, {}, true)
    }
}
