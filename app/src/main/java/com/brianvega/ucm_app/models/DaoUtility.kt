package com.brianvega.ucm_app.models

import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.heroMovie.HeroMovie
import com.brianvega.ucm_app.models.heroMovie.HeroMovieDao
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.models.movie.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DaoUtility {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)
    private var dataBase: DataBase = DataBase.getDataBase()
    private val heroDao: HeroDao = dataBase.heroDao()
    private val movieDao: MovieDao = dataBase.movieDao()
    private val heroMovieDao: HeroMovieDao = dataBase.heroMovieDao()

    fun getAllHeroes(): LiveData<List<Hero>> = heroDao.getAll()

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.getAll()

    fun getMovieById(movieId: Long): LiveData<Movie> = movieDao.getMovieById(movieId)

    fun getHeroesByMovieId(movieId: Long): LiveData<List<HeroDao.HeroMovie>> = heroDao.getHeroesByIdMovie(movieId)

    fun getHeroMovies(movieId: Long): LiveData<List<HeroMovie>> = heroMovieDao.getByIdMovie(movieId)

    fun saveHeroes(heroes: List<Hero>) = scope.launch(Dispatchers.IO) {
        heroDao.insertHeroes(heroes)
    }

    fun saveMovies(movies: List<Movie>) = scope.launch(Dispatchers.IO) {
        movieDao.insertMovies(movies)
    }

    fun saveMovie(movie: Movie) = scope.launch(Dispatchers.IO) {
        movieDao.insertMovie(movie)
    }

    fun updateMovie(movie: Movie) {
        movieDao.updateMovie(movie)
    }

    fun deleteMovie(movie: Movie) = scope.launch(Dispatchers.IO) {
        movieDao.deleteMovie(movie)
    }

    fun saveHeroMovies(heroeMovies: List<HeroMovie>) {
        heroMovieDao.saveHeroMovies(heroeMovies)
    }

}