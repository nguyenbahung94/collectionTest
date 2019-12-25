package com.example.collectionlabtest.espresso.ex1

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTestEx1 {

    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivityEx1::class.java)

    @Test
    fun test_isActivityInView() {
        Espresso.onView(withId(R.id.secondaryex1)).check(matches(isDisplayed()))
    }
    @Test
    fun test_visibility_title_next_Button() {
        Espresso.onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.button_back)).check(matches(isDisplayed()))//method 1
        Espresso.onView(withId(R.id.button_back))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //method 2
    }

    @Test
    fun test_isTitleTextDisplayed() {
        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(matches(withText("text_secondaryactivity")))
    }
}