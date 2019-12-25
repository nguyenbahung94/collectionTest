package com.example.collectionlabtest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.espresso.ex1.MainActivityEx1
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTestEx1 {

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivityEx1::class.java)
        Espresso.onView(withId(R.id.mainex1)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_next_Button() {
        val activityScenario = ActivityScenario.launch(MainActivityEx1::class.java)
        Espresso.onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))//method 1
        Espresso.onView(withId(R.id.button_next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //method 2
    }

    @Test
    fun test_isTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivityEx1::class.java)
        Espresso.onView(withId(R.id.activity_main_title))
            .check(matches(withText("text_mainactivity")))
    }

}