package kst.app.fcmoviegrade.domain.usecase

import kst.app.fcmoviegrade.data.repository.MovieRepository
import kst.app.fcmoviegrade.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}