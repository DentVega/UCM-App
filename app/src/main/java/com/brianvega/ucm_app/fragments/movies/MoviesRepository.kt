package com.brianvega.ucm_app.fragments.movies

import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.DaoUtility
import com.brianvega.ucm_app.models.movie.Movie

class MoviesRepository {

    private var movies: LiveData<List<Movie>>? = null
    private var daoUtility: DaoUtility = DaoUtility()

    fun getMovies(): LiveData<List<Movie>>? = movies

    private fun getMovieDataBase(): LiveData<List<Movie>> = daoUtility.getAllMovies()


    fun callMovies() {
        movies = getMovieDataBase()
    }

    fun deleteMovie(movie: Movie) {
        daoUtility.deleteMovie(movie)
    }


}