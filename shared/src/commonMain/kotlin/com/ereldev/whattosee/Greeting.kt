package com.ereldev.whattosee

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}