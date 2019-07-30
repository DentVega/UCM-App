package com.brianvega.ucm_app.fragments.heroes

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.databinding.HeroesFragmentBinding
import com.brianvega.ucm_app.fragments.BaseFragment
import kotlinx.android.synthetic.main.heroes_fragment.*

class HeroesFragment : BaseFragment() {

    companion object {
        fun newInstance() = HeroesFragment()
    }

    private var viewModel: HeroesViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: HeroesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.heroes_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        val view: View = binding.root
        binding.model = viewModel
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadReferences()
    }

    private fun loadReferences() {
        viewModel?.callHeroes()
        viewModel?.getHeroes()?.observe(this, Observer { heroes ->
            hideProgressBar(progress_bar_heroes, activity as Activity)
            viewModel?.setHeroesInRecyclerAdapter(heroes)
        })
    }

}
