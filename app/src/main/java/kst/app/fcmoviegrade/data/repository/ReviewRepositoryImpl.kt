package kst.app.fcmoviegrade.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kst.app.fcmoviegrade.data.api.ReviewApi
import kst.app.fcmoviegrade.domain.model.Review

class ReviewRepositoryImpl(
    private val reviewApi: ReviewApi,
    private val dispatchers: CoroutineDispatcher
) : ReviewRepository {

    override suspend fun getLatestReview(movieId: String): Review? = withContext(dispatchers) {
        reviewApi.getLatestReview(movieId)
    }

    override suspend fun getAllMovieReviews(movieId: String): List<Review> = withContext(dispatchers) {
        reviewApi.getAllMovieReviews(movieId)
    }

    override suspend fun getAllUserReviews(userId: String): List<Review> = withContext(dispatchers) {
        reviewApi.getAllUserReviews(userId)
    }

    override suspend fun addReview(review: Review): Review = withContext(dispatchers) {
        reviewApi.addReview(review)
    }

    override suspend fun removeReview(review: Review) = withContext(dispatchers) {
        reviewApi.removeReview(review)
    }
}