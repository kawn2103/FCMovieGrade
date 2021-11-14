package kst.app.fcmoviegrade.domain.model

data class MovieReviews(
    val myReview: Review?,
    val othersReview: List<Review>
)
