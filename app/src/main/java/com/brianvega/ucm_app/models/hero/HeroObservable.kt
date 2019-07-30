package com.brianvega.ucm_app.models.hero

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.brianvega.ucm_app.activities.heroe.HeroRepository

class HeroObservable : BaseObservable() {

    private var heroRepository: HeroRepository = HeroRepository()

    fun callHero() {
        heroRepository.callHero()
    }

    fun getHero(): MutableLiveData<Hero> = heroRepository.getHero()

}