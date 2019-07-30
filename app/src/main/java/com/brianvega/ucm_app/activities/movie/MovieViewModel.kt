package com.brianvega.ucm_app.activities.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvHeroesMovieAdapter
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie

class MovieViewModel: ViewModel() {

    private var movieObservable: MovieObservable = MovieObservable()
    private var rvHeroMovieAdapter: RvHeroesMovieAdapter? = null

    fun callMovie(movieId: Long) {
        movieObservable.callMovie(movieId)
    }

    fun callHeroesByIdMovie(movieId: Long) {
        movieObservable.callHeroesByIdMovie(movieId)
    }

    fun getMovie(): LiveData<Movie>? = movieObservable.getMovie()

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = movieObservable.getHeroes()

    fun getHeroAt(position: Int): HeroDao.HeroMovie? {
        val heroes: List<HeroDao.HeroMovie>? = movieObservable.getHeroes()?.value
        return heroes?.get(position)
    }

    fun setHeroesInRecyclerAdapter(heroes: List<HeroDao.HeroMovie>) {
        rvHeroMovieAdapter?.setHeroeMovieList(heroes)
        rvHeroMovieAdapter?.notifyDataSetChanged()
    }

    fun getRvHeroesMovieAdapter(): RvHeroesMovieAdapter? {
        rvHeroMovieAdapter = RvHeroesMovieAdapter(this, R.layout.item_hero_movie)
        return rvHeroMovieAdapter
    }

}