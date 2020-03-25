package com.example.testapp.model

/**
 * Network and cache data model
 */
sealed class Resource<out T : Any> {
    class Data<out T : Any>(val data: T) : Resource<T>()
    class Error(val exception: Throwable) : Resource<Nothing>()

    // Function returns the state into string
    override fun toString(): String {
        return when (this) {
            is Data<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
