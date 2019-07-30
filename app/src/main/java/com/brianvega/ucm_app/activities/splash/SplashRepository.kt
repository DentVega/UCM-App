package com.brianvega.ucm_app.activities.splash

import com.brianvega.ucm_app.models.DaoUtility
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.movie.Movie

class SplashRepository {

    private val daoUtility: DaoUtility = DaoUtility()

    fun saveMovies(movies: List<Movie>) = daoUtility.saveMovies(movies)

    fun saveHeroes(heroes: List<Hero>) = daoUtility.saveHeroes(heroes)

}