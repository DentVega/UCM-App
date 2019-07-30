package com.brianvega.ucm_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.brianvega.ucm_app.activities.movie.MovieViewModel
import com.brianvega.ucm_app.models.hero.HeroDao

class RvHeroesMovieAdapter internal constructor(private var movieViewModel: MovieViewModel, private var resource: Int):
    RecyclerView.Adapter<RvHeroesMovieAdapter.HeroesMovieHolder>(){

    private var heroesMovie: List<HeroDao.HeroMovie> = emptyList()

    fun setHeroeMovieList(heroMovie: List<HeroDao.HeroMovie>) {
        this.heroesMovie = heroesMovie
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesMovieHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return HeroesMovieHolder(binding)
    }

    override fun getItemCount(): Int = heroesMovie.size

    override fun onBindViewHolder(holder: HeroesMovieHolder, position: Int) {
        holder.bind(movieViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    inner class HeroesMovieHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun bind(movieViewModel: MovieViewModel, position: Int) {

        }

    }

}