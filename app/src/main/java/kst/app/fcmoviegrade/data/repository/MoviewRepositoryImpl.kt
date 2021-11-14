package kst.app.fcmoviegrade.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kst.app.fcmoviegrade.data.api.MovieApi
import kst.app.fcmoviegrade.domain.model.Movie

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val dispatchers: CoroutineDispatcher
) : MovieRepository {

    override suspend fun getAllMovies(): List<Movie> = withContext(dispatchers) {
        movieApi.getAllMovies()
    }

    override suspend fun getMovies(movieIds: List<String>): List<Movie> = withContext(dispatchers) {
        movieApi.getMovies(movieIds)
    }
}