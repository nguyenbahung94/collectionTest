package com.example.collectionlabtest.espresso.ex5dialog

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEx5DialogTest {

    @Test
    fun test_showDialog_captureNameInput() {
        //given
        val activityScenario = ActivityScenario.launch(MainActivityEx5Dialog::class.java)
        val EXPETED_NAME = "123456789"

        //execute and verify
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //enter some input
        onView(withId(R.id.md_input_message)).perform(typeText(EXPETED_NAME))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(doesNotExist())
        onView(withId(R.id.text_name)).check(matches(withText(EXPETED_NAME)))
    }
}