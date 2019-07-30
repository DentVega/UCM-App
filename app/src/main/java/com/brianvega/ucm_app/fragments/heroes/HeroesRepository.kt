package com.brianvega.ucm_app.fragments.heroes

import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.DaoUtility
import com.brianvega.ucm_app.models.hero.Hero

class HeroesRepository {

    private var heroes: LiveData<List<Hero>>? = null
    private val daoUtility: DaoUtility = DaoUtility()

    fun getHeroes(): LiveData<List<Hero>>? = heroes

    private fun getHeroesDataBase(): LiveData<List<Hero>> = daoUtility.getAllHeroes()

    fun callHeroes() {
        heroes = getHeroesDataBase()
    }

}