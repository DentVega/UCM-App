package com.brianvega.ucm_app.models.movie

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.fragments.movies.MoviesRepository

class MoviesObservable: BaseObservable() {

    private var movieRepository: MoviesRepository = MoviesRepository()

    fun callMovies() {
        movieRepository.callMovies()
    }

    fun getMovies(): LiveData<List<Movie>>? = movieRepository.getMovies()

    fun deleteMovie(movie: Movie) {
        movieRepository.deleteMovie(movie)
    }

}