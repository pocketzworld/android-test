package com.hr.core

import com.hr.models.Movie

interface MoviesSource {
    suspend fun getMovies(): List<Movie>
}