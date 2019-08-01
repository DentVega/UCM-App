package com.brianvega.ucm_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.models.hero.Hero
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_grid_hero.view.*

class RvGridHeroesAdapter internal constructor(var context: Context, private var selectHero: (Hero) -> Unit) :
    RecyclerView.Adapter<RvGridHeroesAdapter.RvGridHeroesViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    private var heroes: List<Hero> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvGridHeroesViewHolder {
        val itemView = inflater.inflate(R.layout.item_grid_hero, parent, false)
        return RvGridHeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: RvGridHeroesViewHolder, position: Int) {
        holder.bind(heroes[position], selectHero)
    }

    internal fun setHeroes(heroes: List<Hero>) {
        this.heroes = heroes
    }

    inner class RvGridHeroesViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(hero: Hero, selectHero: (Hero) -> Unit) = with(itemView) {
            txt_name_hero.text = hero.name
            Glide.with(itemView.context).load(hero.urlProfilePicture).into(img_photo_hero)
            card_grid_hero.setOnClickListener {
                selectHero(hero)
            }
        }

    }

}