package com.example.testapp.ui.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.Movie


class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val list: ArrayList<Movie> = ArrayList()


        val adapter = MultiViewTypeAdapter(list, this)
        val linearLayoutManager =
            LinearLayoutManager(this, OrientationHelper.VERTICAL, false)

        val mRecyclerView: RecyclerView =
            findViewById<View>(R.id.recyclerViewMovies) as RecyclerView
        mRecyclerView.setLayoutManager(linearLayoutManager)
        mRecyclerView.setItemAnimator(DefaultItemAnimator())
        mRecyclerView.setAdapter(adapter)

    }
}
