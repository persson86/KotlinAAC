package com.mobile.persson.kotlinaac.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mobile.persson.kotlinaac.R
import com.mobile.persson.kotlinaac.data.entity.Movie
import kotlinx.android.synthetic.main.view_item.view.*

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], position)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent?.context).inflate(R.layout.view_item, parent, false))
        return ViewHolder(root)
    }

    fun addMovies(movies: List<Movie>?) {
        if (movies != null) {
            this.movies = movies
            notifyDataSetChanged()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie, position: Int) = with(itemView) {
            tvName.text = movie.title
            tvDescription.text = movie.overview

            itemView.setOnClickListener { Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show() }
        }
    }
}
