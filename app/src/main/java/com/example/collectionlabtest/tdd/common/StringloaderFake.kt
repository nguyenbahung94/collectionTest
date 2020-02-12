package com.example.collectionlabtest.tdd.common

import java.util.*

class StringloaderFake : Stringloader {
    private val fakeStrings = mutableMapOf<Int, String>()

    fun expect(stringValue: StringResValue) {
        fakeStrings[stringValue.resId] = stringValue.value
    }

    override fun get(resourceId: Int): String {
        return fakeStrings[resourceId] ?: throw StringloaderFakeException(resourceId)
    }

    class StringloaderFakeException(id: Int) : Exception(
        "exception $id"
    )

}

data class StringResValue(
    val resId: Int,
    val value: String = UUID.randomUUID().toString()
)