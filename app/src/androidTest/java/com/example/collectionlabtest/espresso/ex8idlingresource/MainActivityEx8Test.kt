package com.example.collectionlabtest.espresso.ex8idlingresource

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityEx8Test {
    private val STRING_TO_BE_TYPED = "123"

    private var mIdlingResource: IdlingResource? = null

    /**
     * Use {@link ActivityScenario to launch and get access to the activity.
     * {@link ActivityScenario#onActivity(ActivityScenario.ActivityAction)} provides a thread-safe
     * mechanism to access the activity.
     */

    @Before
    fun registgerIdlingReSource() {
        val activityScenario = ActivityScenario.launch(MainActivityEx8::class.java)
        activityScenario.onActivity {
            mIdlingResource = it.idlingResource
            // To prove that the test fails, omit this call:
            IdlingRegistry.getInstance().register(mIdlingResource)
        }
    }

    @Test
    fun changeTest_sameActivity() {
        onView(withId(R.id.editTextUserInput)).perform(
            typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard()
        )
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BE_TYPED)))
    }

    @After
    fun unregisterIdlingResource() {
        mIdlingResource?.let {
            IdlingRegistry.getInstance().unregister(mIdlingResource)
        }
    }
}