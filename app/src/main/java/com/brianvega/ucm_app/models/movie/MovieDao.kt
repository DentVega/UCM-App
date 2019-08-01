package com.brianvega.ucm_app.models.movie

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :movieId LIMIT 1")
    fun getMovieById(movieId: Long): LiveData<Movie>

    @Insert
    fun insertMovies(movies: List<Movie>)

    @Insert
    fun insertMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

}