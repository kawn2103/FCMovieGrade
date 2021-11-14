package kst.app.fcmoviegrade.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}