package com.ereldev.whattosee.shared.db

import com.ereldev.whattosee.db.WHat2SeeDatabase
import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): WHat2SeeDatabase {
    val driver = driverFactory.createDriver()
    return WHat2SeeDatabase(driver)
}

