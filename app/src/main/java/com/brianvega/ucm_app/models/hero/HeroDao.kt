package com.brianvega.ucm_app.models.hero

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero")
    fun getAll(): LiveData<List<Hero>>

    @Insert
    fun insertHeroes(heroes: List<Hero>)

}