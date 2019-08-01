package com.brianvega.ucm_app.dialogFragments.heroSelected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvGridHeroesAdapter
import com.brianvega.ucm_app.dialogFragments.BaseDialogFragment
import com.brianvega.ucm_app.models.hero.Hero
import kotlinx.android.synthetic.main.dialog_fragment_hero_selected.*

class HeroSelectedDialogFragment: BaseDialogFragment() {

    private lateinit var rootView: View
    private var heroes: List<Hero> = emptyList()
    private var selectedHero: ((Hero) -> Unit)? = null
    private var rvGridHeroesAdapter: RvGridHeroesAdapter? = null

    companion object {
        fun newInstance(heroes: List<Hero>, selectedHero: (Hero) -> Unit): HeroSelectedDialogFragment {
            val f = HeroSelectedDialogFragment()
            f.heroes = heroes
            f.selectedHero = selectedHero
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.dialog_fragment_hero_selected, container)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadReferences()
    }

    private fun loadReferences() {
        loadRecyclerView()
    }

    private fun loadRecyclerView() {
        rvGridHeroesAdapter = RvGridHeroesAdapter(rootView.context) {
            selectedHero!!(it)
            dismiss()
        }
        rv_heroes_selected.adapter = rvGridHeroesAdapter
        rv_heroes_selected.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvGridHeroesAdapter!!.setHeroes(heroes)
        btn_cancel.setOnClickListener {
            dismiss()
        }
    }

}