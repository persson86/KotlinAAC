package com.mobile.persson.kotlinaac.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.persson.kotlinaac.repository.model.Repo

/**
 * Created by luizfelipepersson on 21/06/17.
 */
abstract class BaseAdapter<D, VH : BaseViewHolder<D>> : RecyclerView.Adapter<VH>() {

    var dataSource: Repo = Repo()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() =1// dataSource.movies.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(getItemViewId(), parent, false)
        return instantiateViewHolder(view)
    }

    abstract fun getItemViewId(): Int

    abstract fun instantiateViewHolder(view: View?): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    fun getItem(position: Int) = dataSource.movies[position]
}