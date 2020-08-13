package com.hr.test

import com.hr.core.MoviesSource
import com.hr.models.Movie
import com.hr.models.Name
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DummyMoviesSourceThatShouldBeReplaced : MoviesSource {
    override suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        delay(2000)
        0.until(20).map { Movie(Name("Dummy movie title $it")) }
    }
}