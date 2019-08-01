package com.brianvega.ucm_app.activities.movie

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.activities.BaseActivity
import com.brianvega.ucm_app.adapters.RvGridHeroesAdapter
import com.brianvega.ucm_app.adapters.RvGridSelectedHeroes
import com.brianvega.ucm_app.databinding.ActivityMovieBinding
import com.brianvega.ucm_app.dialogFragments.heroSelected.HeroSelectedDialogFragment
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.utils.DateFormat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie.*
import java.util.*

class MovieActivity : BaseActivity() {

    private var viewModel: MovieViewModel? = null
    private var rvGridHeroesAdapter: RvGridSelectedHeroes? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        setupBinding()
        viewModel!!.movieId = intent.getLongExtra("id", 0L)
        loadDataInitial(viewModel!!.movieId!!)
    }

    private fun loadDataInitial(movieId: Long) {
        viewModel!!.callHeroMovies(movieId)
        viewModel!!.callAllHeroes()
        viewModel!!.callHeroesByIdMovie(movieId)
        viewModel!!.getHeroes()?.observe(this, Observer { heroMovies ->
            if (heroMovies != null) {
                viewModel?.heroeMovie!!.addAll(heroMovies)
            }
        })
        viewModel?.getAllHeroes()?.observe(this, Observer {
            loadReferences(movieId)
            loadRvHeroesMovie()
        })
    }

    private fun setupBinding() {
        val activityMainBinding: ActivityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        activityMainBinding.model = viewModel
    }

    private fun loadReferences(movieId: Long) {
        loadButton(null)
        ln_release_date.setOnClickListener { showDatePickerDialog(edt_release_date) }
        if (movieId != 0L) {
            viewModel?.callMovie(movieId)
            viewModel?.callHeroesByIdMovie(movieId)
            viewModel?.getMovie()?.observe(this, Observer { movie ->
                if (movie != null) {
                    loadMovie(movie)
                }
            })
            viewModel?.getHeroes()?.observe(this, Observer { heroes ->
                if (heroes != null) {
                    viewModel?.setHeroesInRecyclerAdapter(heroes)
                }
            })
        }
    }

    private fun loadButton(movie: Movie?) {
        fab_save_movie.setOnClickListener {
            onClickSaveMovie(movie)
        }
        fab_add_hero.setOnClickListener {
            val heroNoSelected = viewModel?.getUnselectedHeroes()
            val heroSelectedDialogFragment = HeroSelectedDialogFragment.newInstance(heroNoSelected!!) {
                showToast(resources.getString(R.string.adding_hero))
                viewModel!!.addHero(it)
                loadRvHeroesMovie()
            }
            heroSelectedDialogFragment.show(supportFragmentManager, "heroSelected")
        }
    }

    private fun onClickSaveMovie(movie: Movie?) {
        val name = edt_title_movie.text.toString()
        val date = edt_release_date.text.toString()
        val amountCollected = edt_amount_collected.text.toString()
        val shortSummary = edt_short_summary.text.toString()
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(shortSummary) && !TextUtils.isEmpty(amountCollected) &&
            !TextUtils.isEmpty(date)) {
            if (movie == null) {
                viewModel?.createMovie(name, DateFormat.stringToDate(date), amountCollected.toDouble(), shortSummary, false, null) {
                    showToast(resources.getString(R.string.creation_finished))
                    finish()
                }
            } else {
                viewModel?.createMovie(name, DateFormat.stringToDate(date), amountCollected.toDouble(), shortSummary, true, movie) {
                    showToast(resources.getString(R.string.update_finished))
                    finish()
                }
            }
        } else {
            showToast(resources.getString(R.string.missing_fields_to_fill))
        }
    }

    private fun loadMovie(movie: Movie) {
        edt_title_movie.setText(movie.name)
        edt_release_date.text = DateFormat.dateToString(movie.releaseDate!!)
        edt_amount_collected.setText(movie.amountCollected.toString())
        edt_short_summary.setText(movie.shortSummary)
        Glide.with(this).load(movie.urlMoviePoster).into(img_poster_movie)
        fab_add_hero.visibility = View.VISIBLE
        loadButton(movie)
    }

    private fun showDatePickerDialog(editText: TextView) {
        val datePickerFragment = viewModel?.getDatePickerFragment(this, {
            showToast(it)
        }, {
            editText.text = it
        })
        datePickerFragment?.show(supportFragmentManager, "datePicker")
    }

    private fun loadRvHeroesMovie() {
        rvGridHeroesAdapter = RvGridSelectedHeroes(this, {
            showToast(it.nameHero!!)
        }, {
            showToast("Borrando hero")
        })
        rvGridHeroesAdapter!!.setHeroes(viewModel!!.heroeMovie)
        rcv_heroes_movie.adapter = rvGridHeroesAdapter
        rcv_heroes_movie.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }

}
