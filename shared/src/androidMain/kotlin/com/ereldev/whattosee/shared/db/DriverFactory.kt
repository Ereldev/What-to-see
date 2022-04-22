package com.ereldev.whattosee.shared.db

import android.content.Context
import com.ereldev.whattosee.db.WHat2SeeDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(WHat2SeeDatabase.Schema, context, "test.db")
    }
}