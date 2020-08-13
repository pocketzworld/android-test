package com.hr.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hr.test.MoviesModule.moviesViewModel
import com.koduok.mvi.android.shank.collectStatesOn
import life.shank.android.AutoScoped
import life.shank.android.onReadyFor

class MainActivity : AppCompatActivity(), AutoScoped {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MoviesAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        moviesViewModel.onReadyFor(this) { it.refresh() }
        moviesViewModel.collectStatesOn(this) { _, state ->
            adapter.setMovies(state.movies)
        }
    }

}