package kst.app.fcmoviegrade.data.api

import kst.app.fcmoviegrade.domain.model.Movie

interface MovieApi {

    suspend fun getAllMovies(): List<Movie>

    suspend fun getMovies(movieIds: List<String>): List<Movie>
}