package com.brianvega.ucm_app.activities.movie

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie

class MovieObservable: BaseObservable() {

    private var movieRepository: MovieRepository = MovieRepository()

    fun callMovie(movieId: Long) {
        movieRepository.callMovie(movieId)
    }

    fun callHeroesByIdMovie(movieId: Long) {
        movieRepository.callHeroes(movieId)
    }

    fun getMovie(): LiveData<Movie>? = movieRepository.getMovie()

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = movieRepository.getHeroes()

}