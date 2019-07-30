package com.brianvega.ucm_app.activities.heroe

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.activities.BaseActivity
import com.brianvega.ucm_app.databinding.ActivityHeroBinding

class HeroActivity : BaseActivity() {

    private var heroViewModel: HeroViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)
        setupBinding(savedInstanceState)
    }

    private fun setupBinding(savedInstanceState: Bundle?) {
        val activityMainBinding: ActivityHeroBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero)
        heroViewModel = ViewModelProviders.of(this).get(HeroViewModel::class.java)
        activityMainBinding.model = heroViewModel
        setupHeroUpdate()
    }

    private fun setupHeroUpdate() {
        heroViewModel?.callHero()
        heroViewModel?.getHero()?.observe(this, Observer { hero ->

        })
    }

}
