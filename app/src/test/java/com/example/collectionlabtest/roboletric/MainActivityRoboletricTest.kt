package com.example.collectionlabtest.roboletric

import android.os.Build
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.setupActivity
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainActivityRoboletricTest {
    lateinit var setupActivity: MainActivityRoboletric
    @Before
    public fun setUp() {
        setupActivity = setupActivity(MainActivityRoboletric::class.java)

    }

    @Test
    private fun shouldHaveATextViewDisplayHelloWord() {

    }

    @After
    public fun end() {

    }

}