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

    @Query("SELECT hero.id as idHero, hero.name as nameHero, hero.description as descriptionHero, hero.url_profile_picture as urlPhotoHero FROM hero, heromovie WHERE heromovie.id_movie = :movieId AND heromovie.id_hero = hero.id")
    fun getHeroesByIdMovie(movieId: Long): LiveData<List<HeroMovie>>

    data class HeroMovie(val idHero: String? ,val nameHero: String?, val descriptionHero: String, val urlPhotoHero: String?)

}