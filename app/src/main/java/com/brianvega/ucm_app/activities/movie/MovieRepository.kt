package com.brianvega.ucm_app.activities.movie

import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.DaoUtility
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.heroMovie.HeroMovie
import com.brianvega.ucm_app.models.movie.Movie

class MovieRepository {

    private var movie: LiveData<Movie>? = null
    private var allHeroes: LiveData<List<Hero>>? = null
    private var heroMovies: LiveData<List<HeroMovie>>? = null
    private var heroes: LiveData<List<HeroDao.HeroMovie>>? = null
    private var daoUtility: DaoUtility = DaoUtility()

    fun getMovie(): LiveData<Movie>? = movie

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = heroes

    fun getAllHeroes(): LiveData<List<Hero>>? = allHeroes

    fun getAllHeroMovies(): LiveData<List<HeroMovie>>? = heroMovies

    private fun getMovieDataBase(movieId: Long): LiveData<Movie> = daoUtility.getMovieById(movieId)

    private fun getHeroesByMovieDataBase(movieId: Long): LiveData<List<HeroDao.HeroMovie>> =
        daoUtility.getHeroesByMovieId(movieId)

    private fun getAllHeroDataBase(): LiveData<List<Hero>>? = daoUtility.getAllHeroes()

    private fun getHeroMoviesDataBase(movieId: Long): LiveData<List<HeroMovie>> = daoUtility.getHeroMovies(movieId)

    fun callAllHeroes() {
        allHeroes = getAllHeroDataBase()
    }

    fun callMovie(movieId: Long) {
        movie = getMovieDataBase(movieId)
    }

    fun callHeroes(movieId: Long) {
        heroes = getHeroesByMovieDataBase(movieId)
    }

    fun callHeroMovies(movieId: Long) {
        heroMovies = getHeroMoviesDataBase(movieId)
    }

    fun saveMovie(movie: Movie) {
        daoUtility.saveMovie(movie)
    }

    fun updateMovie(movie: Movie) {
        daoUtility.updateMovie(movie)
    }

    fun saveHeroMovies(heroMovies: List<HeroMovie>) {
        daoUtility.saveHeroMovies(heroMovies)
    }

}