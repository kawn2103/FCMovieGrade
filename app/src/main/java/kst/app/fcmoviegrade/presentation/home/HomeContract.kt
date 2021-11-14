package kst.app.fcmoviegrade.presentation.home

import kst.app.fcmoviegrade.domain.model.FeaturedMovie
import kst.app.fcmoviegrade.domain.model.Movie
import kst.app.fcmoviegrade.presentation.BasePresenter
import kst.app.fcmoviegrade.presentation.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
                featuredMovie: FeaturedMovie?,
                movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}