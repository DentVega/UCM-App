package com.brianvega.ucm_app.activities.movie

import android.app.Activity
import android.app.DatePickerDialog
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.adapters.RvHeroesMovieAdapter
import com.brianvega.ucm_app.dialogFragments.datePicker.DatePickerFragment
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie
import java.util.*

class MovieViewModel: ViewModel() {

    private var movieObservable: MovieObservable = MovieObservable()
    private var rvHeroMovieAdapter: RvHeroesMovieAdapter? = null
    private var dateSelected: String? = null
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

    fun createMovie(name:String?, releaseDate: Date?, amountCollected: Double?, shortSummary: String?, showToast:() -> Unit) {
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(shortSummary) && releaseDate != null) {
            val movie = Movie(name, "", releaseDate, amountCollected, shortSummary)
            saveMovie(movie)
        } else {
            showToast()
        }
    }

    private fun saveMovie(movie: Movie) {
        movieObservable.saveMovie(movie)
    }

    private fun setCurrentDate() {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        mYear = calendar.get(Calendar.YEAR)
        mMonth = calendar.get(Calendar.MONTH)
        mDay = calendar.get(Calendar.DAY_OF_MONTH)
    }

    fun getDatePickerFragment(activity: Activity, showToast: (String) -> Unit, setText:(String) -> Unit): DatePickerFragment {
        return DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            if (year < mYear || month < mMonth || dayOfMonth < mDay) {
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

}