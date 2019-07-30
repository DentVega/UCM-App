package com.brianvega.ucm_app.activities.heroe

import androidx.lifecycle.MutableLiveData
import com.brianvega.ucm_app.models.hero.Hero

class HeroRepository {

    private var hero = MutableLiveData<Hero>()

    fun getHero(): MutableLiveData<Hero> = hero

    fun callHero() {

    }

}