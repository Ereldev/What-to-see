package com.ereldev.whattosee.shared.db

import com.ereldev.whattosee.db.WHat2SeeDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(WHat2SeeDatabase.Schema, "test.db")
    }
}