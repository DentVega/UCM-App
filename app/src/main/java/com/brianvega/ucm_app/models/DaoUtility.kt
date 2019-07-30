package com.brianvega.ucm_app.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.models.movie.MovieDao

class DaoUtility {

    private var dataBase: DataBase = DataBase.getDataBase()
    private val heroDao: HeroDao = dataBase.heroDao()
    private val movieDao: MovieDao = dataBase.movieDao()

    fun getAllHeroes(): LiveData<List<Hero>> = heroDao.getAll()

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.getAll()

    fun saveHeroes(heroes: List<Hero>) {
        heroDao.insertHeroes(heroes)
    }

    fun saveMovies(movies: List<Movie>) {
        movieDao.insertMovies(movies)
    }

}