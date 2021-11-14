package kst.app.fcmoviegrade.domain.usecase

import kst.app.fcmoviegrade.data.repository.ReviewRepository
import kst.app.fcmoviegrade.data.repository.UserRepository
import kst.app.fcmoviegrade.domain.model.MovieReviews
import kst.app.fcmoviegrade.domain.model.Review
import kst.app.fcmoviegrade.domain.model.User

class GetAllMovieReviewsUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(movieId: String): MovieReviews {
        val reviews = reviewRepository.getAllMovieReviews(movieId)
        val user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())

            return MovieReviews(null, reviews)
        }

        return MovieReviews(
            reviews.find { it.userId == user.id },
            reviews.filter { it.userId != user.id }
        )
    }
}