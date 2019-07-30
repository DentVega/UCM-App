package com.brianvega.ucm_app.fragments.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvHeroesAdapter
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroesObservable
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesViewModel : ViewModel() {

    private var heroesObservable: HeroesObservable = HeroesObservable()
    private var rvHeroAdapter: RvHeroesAdapter? = null

    fun callHeroes() {
        heroesObservable.callHeroes()
    }

    fun getHeroes(): LiveData<List<Hero>>? = heroesObservable.getHeroes()

    fun setHeroesInRecyclerAdapter(heroes: List<Hero>) {
        rvHeroAdapter?.setHeroList(heroes)
        rvHeroAdapter?.notifyDataSetChanged()
    }

    fun getRvHeroesAdapter(): RvHeroesAdapter? {
        rvHeroAdapter = RvHeroesAdapter(this, R.layout.item_hero)
        return rvHeroAdapter
    }

    fun getHeroAt(position: Int): Hero? {
        val heroes: List<Hero>? = heroesObservable.getHeroes()?.value
        return heroes?.get(position)
    }

}
