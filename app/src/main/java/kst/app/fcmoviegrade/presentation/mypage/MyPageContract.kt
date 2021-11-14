package kst.app.fcmoviegrade.presentation.mypage

import kst.app.fcmoviegrade.domain.model.ReviewedMovie
import kst.app.fcmoviegrade.presentation.BasePresenter
import kst.app.fcmoviegrade.presentation.BaseView

interface MyPageContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showNoDataDescription(message: String)

        fun showErrorDescription(message: String)

        fun showReviewedMovies(reviewedMovies: List<ReviewedMovie>)
    }

    interface Presenter : BasePresenter
}