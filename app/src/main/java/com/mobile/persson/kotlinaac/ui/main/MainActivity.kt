package com.mobile.persson.kotlinaac.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.mobile.persson.kotlinaac.R
import com.mobile.persson.kotlinaac.base.BaseLifecycleActivity
import com.mobile.persson.kotlinaac.data.entity.Repo

class MainActivity : BaseLifecycleActivity<MainViewModel>() {

    override val viewModelClass = MainViewModel::class.java

    private val rv by lazy { findViewById(R.id.rv) as RecyclerView }
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        observeLiveData()
    }

    private fun setAdapter() {
        rv.setHasFixedSize(true)
        rv.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.reposLiveData.observe(this, Observer<Repo> {
            it?.let {
                (rv.adapter as MainAdapter).addMovies(it.movies)
            }
        })
        viewModel.throwableLiveData.observe(this, Observer<Throwable> {
            it?.let {
                Snackbar.make(rv, it.localizedMessage, Snackbar.LENGTH_LONG).show()
                Log.v("LFSP", it.localizedMessage)
            }
        })
    }
}
