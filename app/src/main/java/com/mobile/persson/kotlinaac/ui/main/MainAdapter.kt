package com.mobile.persson.kotlinaac.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.mobile.persson.kotlinaac.R
import com.mobile.persson.kotlinaac.base.BaseAdapter
import com.mobile.persson.kotlinaac.base.BaseViewHolder
import com.mobile.persson.kotlinaac.repository.model.Movie
import com.mobile.persson.kotlinaac.repository.model.Repo
import kotlinx.android.synthetic.main.view_item.view.*
import java.util.ArrayList

/**
 * Created by luizfelipepersson on 21/06/17.
 */
/*
class MainAdapter : BaseAdapter<Repo, MainAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Repo>(itemView) {

        val tvName: TextView by lazy { itemView?.findViewById(R.id.tvName) as TextView }
        val tvDescription: TextView by lazy { itemView?.findViewById(R.id.tvDescription) as TextView }

        override fun onBind(item: Movie) {
            tvName.text = item.title
            tvDescription.text = item.overview
        }
    }
}*/

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

            itemView.setOnClickListener{Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()}
        }
    }
}
