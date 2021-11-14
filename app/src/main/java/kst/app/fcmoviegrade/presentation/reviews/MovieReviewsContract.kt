package kst.app.fcmoviegrade.presentation.reviews

import kst.app.fcmoviegrade.domain.model.Movie
import kst.app.fcmoviegrade.domain.model.MovieReviews
import kst.app.fcmoviegrade.domain.model.Review
import kst.app.fcmoviegrade.presentation.BasePresenter
import kst.app.fcmoviegrade.presentation.BaseView

interface MovieReviewsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovieInformation(movie: Movie)

        fun showReviews(reviews: MovieReviews)

        fun showErrorToast(message: String)
    }

    interface Presenter : BasePresenter {

        val movie: Movie

        fun requestAddReview(content: String, score: Float)

        fun requestRemoveReview(review: Review)
    }
}