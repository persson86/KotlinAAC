package com.mobile.persson.kotlinaac.ui.main

import android.view.View
import android.widget.TextView
import com.mobile.persson.kotlinaac.R
import com.mobile.persson.kotlinaac.base.BaseAdapter
import com.mobile.persson.kotlinaac.base.BaseViewHolder
import com.mobile.persson.kotlinaac.repository.entity.Repo

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainAdapter : BaseAdapter<Repo, MainAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Repo>(itemView) {

        val tvName: TextView by lazy { itemView?.findViewById(R.id.tvName) as TextView }
        val tvDescription: TextView by lazy { itemView?.findViewById(R.id.tvDescription) as TextView }
        val tvLogin: TextView by lazy { itemView?.findViewById(R.id.tvLogin) as TextView }

        override fun onBind(item: Repo) {
            tvName.text = item.name
            tvDescription.text = item.description
            tvLogin.text = item.owner.login
        }
    }
}