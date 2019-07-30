package com.brianvega.ucm_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.brianvega.ucm_app.BR
import com.brianvega.ucm_app.fragments.movies.MoviesViewModel
import com.brianvega.ucm_app.models.movie.Movie

class RvMoviesAdapter internal constructor(private var moviesViewModel: MoviesViewModel, private var resource: Int) :
    RecyclerView.Adapter<RvMoviesAdapter.MoviesViewHolder>() {

    private var movies: List<Movie> = emptyList()

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    inner class MoviesViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun bind(moviesViewModel: MoviesViewModel, position: Int) {
            binding?.setVariable(BR.model,  moviesViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }

    }


}