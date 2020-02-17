package com.example.collectionlabtest.roboletric

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.setupActivity
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityRoboletricTest {

    @Before
    public fun setUp() {
        setupActivity(MainActivityRoboletric::class.java)

    }

    @Test
    public fun shouldReturnTrue() {
        assertEquals(1, 2)

    }

    @After
    public fun end() {

    }

}