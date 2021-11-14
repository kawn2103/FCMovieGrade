package kst.app.fcmoviegrade.domain.usecase

import kst.app.fcmoviegrade.data.repository.ReviewRepository
import kst.app.fcmoviegrade.data.repository.UserRepository
import kst.app.fcmoviegrade.domain.model.Movie
import kst.app.fcmoviegrade.domain.model.Review
import kst.app.fcmoviegrade.domain.model.User

class SubmitReviewUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(
        movie: Movie,
        content: String,
        score: Float
    ): Review {
        var user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                movieId = movie.id,
                content = content,
                score = score
            )
        )
    }
}