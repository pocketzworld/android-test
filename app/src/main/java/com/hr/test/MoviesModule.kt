package com.hr.test

import com.hr.core.MoviesViewModel
import life.shank.ShankModule
import life.shank.new
import life.shank.scoped

object MoviesModule : ShankModule {
    private val moviesSource = new { -> DummyMoviesSourceThatShouldBeReplaced() }
    val moviesViewModel = scoped { -> MoviesViewModel(moviesSource()) }
}