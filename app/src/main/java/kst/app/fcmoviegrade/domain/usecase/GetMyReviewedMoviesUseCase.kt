package kst.app.fcmoviegrade.domain.usecase

import kst.app.fcmoviegrade.data.repository.MovieRepository
import kst.app.fcmoviegrade.data.repository.ReviewRepository
import kst.app.fcmoviegrade.data.repository.UserRepository
import kst.app.fcmoviegrade.domain.model.ReviewedMovie
import kst.app.fcmoviegrade.domain.model.User

class GetMyReviewedMoviesUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository,
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): List<ReviewedMovie> {
        val user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())
            return emptyList()
        }

        val reviews = reviewRepository.getAllUserReviews(user.id!!)
            .filter { it.movieId.isNullOrBlank().not() }

        if (reviews.isNullOrEmpty()) {
            return emptyList()
        }

        return movieRepository
            .getMovies(reviews.map { it.movieId!! })
            .mapNotNull { movie ->
                val relatedReview = reviews.find { it.movieId == movie.id }
                relatedReview?.let { ReviewedMovie(movie, it) }
            }
    }
}