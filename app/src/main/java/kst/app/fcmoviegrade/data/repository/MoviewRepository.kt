package kst.app.fcmoviegrade.data.repository

import kst.app.fcmoviegrade.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>

    suspend fun getMovies(movieIds: List<String>): List<Movie>
}