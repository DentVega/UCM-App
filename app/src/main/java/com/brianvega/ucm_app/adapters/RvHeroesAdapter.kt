package com.brianvega.ucm_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.brianvega.ucm_app.BR
import com.brianvega.ucm_app.fragments.heroes.HeroesViewModel
import com.brianvega.ucm_app.models.hero.Hero

class RvHeroesAdapter internal constructor(private var heroesViewModel: HeroesViewModel, private var resource: Int) :
    RecyclerView.Adapter<RvHeroesAdapter.HeroesViewHolder>() {

    private var heroes: List<Hero> = emptyList()

    fun setHeroList(heroes: List<Hero>) {
        this.heroes = heroes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return HeroesViewHolder(binding)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroesViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    inner class HeroesViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun bind(heroesViewModel: HeroesViewModel, position: Int) {
            binding?.setVariable(BR.model, heroesViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }

    }

}