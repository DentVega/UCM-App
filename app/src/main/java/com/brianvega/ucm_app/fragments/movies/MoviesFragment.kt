package com.brianvega.ucm_app.fragments.movies

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.brianvega.ucm_app.R
import com.brianvega.ucm_app.databinding.MoviesFragmentBinding
import com.brianvega.ucm_app.fragments.BaseFragment
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment: BaseFragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private var viewModel: MoviesViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: MoviesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.movies_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        val view: View = binding.root
        binding.model = viewModel
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadReferences()
    }

    private fun loadReferences() {
        viewModel?.activity = activity
        viewModel?.callMovies()
        viewModel?.getMovies()?.observe(this, Observer { movies ->
            hideProgressBar(progress_bar_movies, activity as Activity)
            viewModel?.setMoviesInRecyclerAdapter(movies)
        })
    }

}