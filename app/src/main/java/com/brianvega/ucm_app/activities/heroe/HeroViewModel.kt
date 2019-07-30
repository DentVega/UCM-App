package com.brianvega.ucm_app.activities.heroe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroObservable

class HeroViewModel: ViewModel() {

    private var repository: HeroRepository = HeroRepository()
    private var heroObservable: HeroObservable = HeroObservable()

    fun callHero() {
        heroObservable.callHero()
    }

    fun getHero(): MutableLiveData<Hero> = heroObservable.getHero()


}