package com.brianvega.ucm_app.activities.movie

import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.DaoUtility
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie

class MovieRepository {

    private var movie: LiveData<Movie>? = null
    private var heroes: LiveData<List<HeroDao.HeroMovie>>? = null
    private var daoUtility: DaoUtility = DaoUtility()

    fun getMovie(): LiveData<Movie>? = movie

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = heroes

    private fun getMovieDataBase(movieId: Long): LiveData<Movie> = daoUtility.getMovieById(movieId)

    private fun getHeroesByMovieDataBase(movieId: Long): LiveData<List<HeroDao.HeroMovie>> = daoUtility.getHeroesByMovieId(movieId)

    fun callMovie(movieId: Long) {
        movie = getMovieDataBase(movieId)
    }

    fun callHeroes(movieId: Long) {
        heroes = getHeroesByMovieDataBase(movieId)
    }

}