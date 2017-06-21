package com.mobile.persson.kotlinaac.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by luizfelipepersson on 21/06/17.
 */
abstract class BaseViewHolder<D>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: D)

}