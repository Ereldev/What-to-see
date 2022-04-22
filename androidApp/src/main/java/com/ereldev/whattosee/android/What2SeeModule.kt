package com.ereldev.whattosee.android

import com.ereldev.whattosee.shared.db.DriverFactory
import com.ereldev.whattosee.shared.db.createDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val what2SeeModule = module {

    single { createDatabase(get()) }
    single { DriverFactory(androidContext()) }

}