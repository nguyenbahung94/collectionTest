package com.example.collectionlabtest.tdd.common

import android.content.Context

interface Stringloader {
    fun get(resourceId: Int): String

    companion object {
        fun invoke(context: Context): Stringloader {
            return object : Stringloader {
                override fun get(resourceId: Int): String {
                    return context.getString(resourceId)
                }

            }
        }
    }
}