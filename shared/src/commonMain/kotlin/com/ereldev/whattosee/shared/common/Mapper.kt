package com.ereldev.whattosee.shared.common

abstract class Mapper<F, T> {

    abstract fun from(from: F): T

    fun to(to: T): F {
        throw Exception("Mapper.to() not implemented")
    }

}