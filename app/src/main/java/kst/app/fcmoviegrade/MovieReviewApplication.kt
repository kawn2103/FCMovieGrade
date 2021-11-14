package kst.app.fcmoviegrade

import android.app.Application
import androidx.viewbinding.BuildConfig
import kst.app.fcmoviegrade.di.appModule
import kst.app.fcmoviegrade.di.dataModule
import kst.app.fcmoviegrade.di.domainModule
import kst.app.fcmoviegrade.di.presenterModule
import kst.app.fcmoviegrade.utility.MovieDataGenerator
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MovieReviewApplication)
            modules(appModule + dataModule + domainModule + presenterModule)
        }

        //MovieDataGenerator().generate()
    }
}