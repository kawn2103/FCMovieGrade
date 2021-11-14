package kst.app.fcmoviegrade.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)