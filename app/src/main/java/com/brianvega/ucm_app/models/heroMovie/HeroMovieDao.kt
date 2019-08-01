package com.brianvega.ucm_app.models.heroMovie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroMovieDao {

    @Query("SELECT * FROM heromovie WHERE id_movie = :movieId")
    fun getByIdMovie(movieId: Long): LiveData<List<HeroMovie>>

    @Insert
    fun saveHeroMovies(heroMovies: List<HeroMovie>)

}