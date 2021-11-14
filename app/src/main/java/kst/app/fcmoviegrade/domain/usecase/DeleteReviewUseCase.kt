package kst.app.fcmoviegrade.domain.usecase

import kst.app.fcmoviegrade.data.repository.ReviewRepository
import kst.app.fcmoviegrade.domain.model.Review

class DeleteReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(review: Review) =
        reviewRepository.removeReview(review)
}