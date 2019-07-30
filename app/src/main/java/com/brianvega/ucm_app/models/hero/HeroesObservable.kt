package com.brianvega.ucm_app.models.hero

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.fragments.heroes.HeroesRepository

class HeroesObservable: BaseObservable() {

    private var heroRepository: HeroesRepository = HeroesRepository()

    fun callHeroes() {
        heroRepository.callHeroes()
    }

    fun getHeroes(): LiveData<List<Hero>>? = heroRepository.getHeroes()

}