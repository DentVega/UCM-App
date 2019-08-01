package com.brianvega.ucm_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.models.hero.HeroDao
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_heromovie.view.*

class RvGridSelectedHeroes internal constructor(var context: Context, private var selectHero: (HeroDao.HeroMovie) -> Unit,
                                                private var deleteHero: (HeroDao.HeroMovie) -> Unit) :
    RecyclerView.Adapter<RvGridSelectedHeroes.RvGridHeroesViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    private var heroes: List<HeroDao.HeroMovie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvGridHeroesViewHolder {
        val itemView = inflater.inflate(R.layout.item_heromovie, parent, false)
        return RvGridHeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: RvGridHeroesViewHolder, position: Int) {
        holder.bind(heroes[position], selectHero, deleteHero)
    }

    internal fun setHeroes(heroes: List<HeroDao.HeroMovie>?) {
        if (heroes != null) this.heroes = heroes
    }

    inner class RvGridHeroesViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(hero: HeroDao.HeroMovie, selectHero: (HeroDao.HeroMovie) -> Unit, deleteHero: (HeroDao.HeroMovie) -> Unit) = with(itemView) {
            txt_name_hero.text = hero.nameHero
            Glide.with(itemView.context).load(hero.urlPhotoHero).into(img_photo_hero)
            card_grid_hero.setOnClickListener {
                selectHero(hero)
            }
            img_btn_delete_hero.setOnClickListener {
                deleteHero(hero)
            }
        }

    }

}