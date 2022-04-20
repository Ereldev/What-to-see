package com.ereldev.whattosee.shared.common

expect class DateUtils {

    companion object {
        fun formatDate(input: String): String
        fun nowMinusOneMonth(): String
    }

}