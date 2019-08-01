package com.brianvega.ucm_app.activities.movie

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.heroMovie.HeroMovie
import com.brianvega.ucm_app.models.movie.Movie

class MovieObservable: BaseObservable() {

    private var movieRepository: MovieRepository = MovieRepository()

    fun callMovie(movieId: Long) {
        movieRepository.callMovie(movieId)
    }

    fun callHeroesByIdMovie(movieId: Long) {
        movieRepository.callHeroes(movieId)
    }

    fun callAllHeroes() {
        movieRepository.callAllHeroes()
    }

    fun callHeroMovies(movieId: Long) {
        movieRepository.callHeroMovies(movieId)
    }

    fun getMovie(): LiveData<Movie>? = movieRepository.getMovie()

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = movieRepository.getHeroes()

    fun saveMovie(movie: Movie) = movieRepository.saveMovie(movie)

    fun saveHeroMovies(heroMovies: List<HeroDao.HeroMovie>, movieId: Long) {
        val heroMoviesAux = mutableListOf<HeroMovie>()
        for (heroMovie in heroMovies) {
            heroMoviesAux.add(HeroMovie(heroMovie.idHero, movieId, 1))
        }
        movieRepository.saveHeroMovies(heroMoviesAux)

    }

    fun updateMovie(movie: Movie) = movieRepository.updateMovie(movie)

    fun getAllHeroes(): LiveData<List<Hero>>? = movieRepository.getAllHeroes()

    fun getAllHeroMovies(): LiveData<List<HeroMovie>>? = movieRepository.getAllHeroMovies()

}