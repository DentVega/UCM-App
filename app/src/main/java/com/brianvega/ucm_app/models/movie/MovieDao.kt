package com.brianvega.ucm_app.models.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    @Insert
    fun insertMovies(movies: List<Movie>)

}