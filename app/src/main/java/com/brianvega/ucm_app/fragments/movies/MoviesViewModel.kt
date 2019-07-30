package com.brianvega.ucm_app.fragments.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvMoviesAdapter
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.models.movie.MoviesObservable

class MoviesViewModel: ViewModel() {

    private var moviesObservable: MoviesObservable = MoviesObservable()
    private var rvMovieAdapter: RvMoviesAdapter? = null

    fun callMovies() {
        moviesObservable.callMovies()
    }

    fun getMovies(): LiveData<List<Movie>>? = moviesObservable.getMovies()

    fun setMoviesInRecyclerAdapter(movies: List<Movie>) {
        rvMovieAdapter?.setMovieList(movies)
        rvMovieAdapter?.notifyDataSetChanged()
    }

    fun getRvMoviesAdapter(): RvMoviesAdapter? {
        rvMovieAdapter = RvMoviesAdapter(this, R.layout.item_movie)
        return rvMovieAdapter
    }

    fun getMovieAt(position: Int): Movie? {
        val movies: List<Movie>? = moviesObservable.getMovies()?.value
        return movies?.get(position)
    }

}