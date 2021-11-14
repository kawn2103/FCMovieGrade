package kst.app.fcmoviegrade.di

import android.app.Activity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kst.app.fcmoviegrade.data.api.*
import kst.app.fcmoviegrade.data.preference.PreferenceManager
import kst.app.fcmoviegrade.data.preference.SharedPreferenceManager
import kst.app.fcmoviegrade.data.repository.*
import kst.app.fcmoviegrade.domain.model.Movie
import kst.app.fcmoviegrade.domain.usecase.*
import kst.app.fcmoviegrade.presentation.home.HomeContract
import kst.app.fcmoviegrade.presentation.home.HomeFragment
import kst.app.fcmoviegrade.presentation.home.HomePresenter
import kst.app.fcmoviegrade.presentation.mypage.MyPageContract
import kst.app.fcmoviegrade.presentation.mypage.MyPageFragment
import kst.app.fcmoviegrade.presentation.mypage.MyPagePresenter
import kst.app.fcmoviegrade.presentation.reviews.MovieReviewsContract
import kst.app.fcmoviegrade.presentation.reviews.MovieReviewsFragment
import kst.app.fcmoviegrade.presentation.reviews.MovieReviewsPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }
    single<UserApi> { UserFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }
}

val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { GetAllMovieReviewsUseCase(get(), get()) }
    factory { GetMyReviewedMoviesUseCase(get(), get(), get()) }
    factory { SubmitReviewUseCase(get(), get()) }
    factory { DeleteReviewUseCase(get()) }
}

val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(), get()) }
    }
    scope<MovieReviewsFragment> {
        scoped<MovieReviewsContract.Presenter> { (movie: Movie) ->
            MovieReviewsPresenter(movie, getSource(), get(), get(), get())
        }
    }
    scope<MyPageFragment> {
        scoped<MyPageContract.Presenter> { MyPagePresenter(getSource(), get()) }
    }
}