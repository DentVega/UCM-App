package com.brianvega.ucm_app.activities.movie

import android.app.Activity
import android.app.DatePickerDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvHeroesMovieAdapter
import com.brianvega.ucm_app.dialogFragments.datePicker.DatePickerFragment
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.heroMovie.HeroMovie
import com.brianvega.ucm_app.models.movie.Movie
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class MovieViewModel : ViewModel() {

    private var movieObservable: MovieObservable = MovieObservable()
    private var rvHeroMovieAdapter: RvHeroesMovieAdapter? = null
    var heroeMovie = mutableListOf<HeroDao.HeroMovie>()
    private var dateSelected: String? = null
    var movieId: Long? = null
    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0

    init {
        setCurrentDate()
    }

    fun callMovie(movieId: Long) {
        movieObservable.callMovie(movieId)
    }

    fun callHeroesByIdMovie(movieId: Long) {
        movieObservable.callHeroesByIdMovie(movieId)
    }

    fun callAllHeroes() {
        movieObservable.callAllHeroes()
    }

    fun callHeroMovies(movieId: Long) {
        movieObservable.callHeroMovies(movieId)
    }

    fun getAllHeroes():LiveData<List<Hero>>? = movieObservable.getAllHeroes()

    fun getMovie(): LiveData<Movie>? = movieObservable.getMovie()

    fun getHeroes(): LiveData<List<HeroDao.HeroMovie>>? = movieObservable.getHeroes()

    fun getHeroAt(position: Int): HeroDao.HeroMovie? {
        val heroes: List<HeroDao.HeroMovie>? = movieObservable.getHeroes()?.value
        return heroes?.get(position)
    }

    fun setHeroesInRecyclerAdapter(heroes: List<HeroDao.HeroMovie>) {
        rvHeroMovieAdapter?.setHeroeMovieList(heroes)
        rvHeroMovieAdapter?.notifyDataSetChanged()
    }

    fun getRvHeroesMovieAdapter(): RvHeroesMovieAdapter? {
        rvHeroMovieAdapter = RvHeroesMovieAdapter(this, R.layout.item_hero_movie)
        return rvHeroMovieAdapter
    }

    fun createMovie(
        name: String?, releaseDate: Date?, amountCollected: Double?, shortSummary: String?,
        update: Boolean, currentMovie: Movie?, complete: () -> Unit
    ) {
        val movie = Movie(name, "", releaseDate, amountCollected, shortSummary)
        if (!update) {
            doAsync {
                saveMovie(movie)
                uiThread {
                    complete()
                }
            }
        } else {
            currentMovie?.name = name
            currentMovie?.releaseDate = releaseDate
            currentMovie?.amountCollected = amountCollected
            currentMovie?.shortSummary = shortSummary
            doAsync {
                updateMovie(currentMovie!!)
                uiThread {
                    complete()
                }
            }
        }
    }

    private fun saveMovie(movie: Movie) {
        movieObservable.saveMovie(movie)
        movieObservable.saveHeroMovies(heroeMovie, movieId!!)
    }

    private fun updateMovie(movie: Movie) {
        movieObservable.updateMovie(movie)
        movieObservable.saveHeroMovies(heroeMovie, movieId!!)
    }

    private fun setCurrentDate() {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        mYear = calendar.get(Calendar.YEAR)
        mMonth = calendar.get(Calendar.MONTH)
        mDay = calendar.get(Calendar.DAY_OF_MONTH)
    }

    fun getDatePickerFragment(
        activity: Activity, showToast: (String) -> Unit,
        setText: (String) -> Unit
    ): DatePickerFragment {
        return DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            if (year < mYear || month < mMonth) {
                showToast(activity.resources.getString(R.string.not_select_past_dates))
            } else {
                dateSelected = "$year-${convertIntToDateFormat(month + 1)}-${convertIntToDateFormat(dayOfMonth)}"
                setText("${convertIntToDateFormat(dayOfMonth)}/${convertIntToDateFormat(month + 1)}/$year")
            }
        })
    }

    private fun convertIntToDateFormat(n: Int): String {
        return if (n <= 9) "0$n" else n.toString()
    }

    fun getUnselectedHeroes(): List<Hero>  {
        val heroesSelected: List<HeroDao.HeroMovie>? = movieObservable.getHeroes()?.value
        val allHeroes: List<Hero>? = movieObservable.getAllHeroes()?.value
        val allHeroMovies: List<HeroMovie>? = movieObservable.getAllHeroMovies()?.value
        val heroesNoSelected = mutableListOf<Hero>()
        if (heroesSelected != null && allHeroMovies != null) {
            for (hero in allHeroes!!) {
                val heroMovieExist = heroesSelected.find { it.idHero == hero.id }
                if (heroMovieExist == null) {
                    heroesNoSelected.add(hero)
                }
            }
        } else {
            return allHeroes!!
        }
        return heroesNoSelected
    }

    fun addHero(hero: Hero) {
        val heroMovie: HeroDao.HeroMovie = HeroDao.HeroMovie(hero.id, hero.name, hero.description!!, hero.urlProfilePicture)
        heroeMovie.add(heroMovie)
    }

}