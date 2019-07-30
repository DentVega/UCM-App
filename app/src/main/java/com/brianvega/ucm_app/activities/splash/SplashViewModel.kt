package com.brianvega.ucm_app.activities.splash

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.models.CreateData
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.utils.SharedPreferencesUtil
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SplashViewModel: ViewModel() {

    private var repository: SplashRepository = SplashRepository()

    fun isFirstTime(activity: Activity): Boolean = SharedPreferencesUtil.isFirstTime(activity)

    fun createDataInitial(activity: Activity, nextActivity: () -> Unit) {
        doAsync {
            saveHeroes(CreateData.createDataHeroeV1())
            saveMovies(CreateData.createDataMovieV1())
            uiThread {
                SharedPreferencesUtil.setFirstTime(activity, true)
                nextActivity()
            }
        }
    }

    private fun saveHeroes(heroes: List<Hero>) {
        repository.saveHeroes(heroes)
    }

    private fun saveMovies(movies: List<Movie>) {
        repository.saveMovies(movies)
    }

}