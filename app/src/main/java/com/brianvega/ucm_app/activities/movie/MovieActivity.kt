package com.brianvega.ucm_app.activities.movie

import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.activities.BaseActivity
import com.brianvega.ucm_app.databinding.ActivityMovieBinding
import com.brianvega.ucm_app.models.movie.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity() {

    private var viewModel: MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        val movieId: Long = intent.getLongExtra("id", 0L)
        setupBinding(savedInstanceState)
        loadReferences(movieId)
    }

    private fun setupBinding(savedInstanceState: Bundle?) {
        val activityMainBinding: ActivityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        activityMainBinding.model = viewModel
    }

    private fun loadReferences(movieId: Long) {
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
        loadButton()
    }

    private fun loadButton() {
        fab_save_movie.setOnClickListener {
            viewModel?.createMovie(null, null, null, null) {
                showToast(resources.getString(R.string.missing_fields_to_fill))
            }
        }
    }

    private fun loadMovie(movie: Movie) {
        edt_title_movie.setText(movie.name)
        edt_release_date.setText(movie.releaseDate.toString())
        edt_release_date.setOnClickListener { showDatePickerDialog(edt_release_date) }
        edt_amount_collected.setText(movie.amountCollected.toString())
        edt_short_summary.setText(movie.shortSummary)
        Glide.with(this).load(movie.urlMoviePoster).into(img_poster_movie)
    }

    private fun showDatePickerDialog(editText: TextView) {
        val datePickerFragment = viewModel?.getDatePickerFragment(this, {
            showToast(it)
        }, {
            editText.text = it
        })
        datePickerFragment?.show(supportFragmentManager, "datePicker")
    }

}
