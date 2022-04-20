package com.ereldev.whattosee.android

import android.app.Application
import com.ereldev.whattosee.android.category.categoryModule
import com.ereldev.whattosee.android.show.showsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class What2SeeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@What2SeeApplication)
            modules(
                categoryModule,
                showsModule
            )
        }
    }

}