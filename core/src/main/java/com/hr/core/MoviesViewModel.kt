package com.hr.core

import com.hr.core.MoviesViewModel.Input
import com.hr.core.MoviesViewModel.Input.Refresh
import com.hr.core.MoviesViewModel.State
import com.hr.core.MoviesViewModel.State.Idle
import com.hr.core.MoviesViewModel.State.Loaded
import com.hr.models.Movie
import com.koduok.mvi.Mvi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesViewModel(private val moviesSource: MoviesSource) : Mvi<Input, State>(Idle) {

    fun refresh() = input(Refresh)

    override fun handleInput(input: Input): Flow<State> = when (input) {
        Refresh -> doRefresh()
    }

    private fun doRefresh(): Flow<State> = flow {
        emit(State.Loading(emptyList()))

        val movies = moviesSource.getMovies()
        emit(Loaded(movies))
    }

    sealed class Input {
        internal object Refresh : Input()
    }

    sealed class State {
        abstract val movies: List<Movie>

        object Idle : State() {
            override val movies: List<Movie> get() = emptyList()
        }

        data class Loading(override val movies: List<Movie>) : State()
        data class Loaded(override val movies: List<Movie>) : State()
    }

}