package com.hr.core

import com.hr.models.Movie
import kotlinx.coroutines.CompletableDeferred

class FakeMoviesSource : MoviesSource {
    var getMovies = CompletableDeferred<List<Movie>>()

    override suspend fun getMovies(): List<Movie> = getMovies.await()

    fun resetGetMovies() {
        getMovies = CompletableDeferred()
    }
}