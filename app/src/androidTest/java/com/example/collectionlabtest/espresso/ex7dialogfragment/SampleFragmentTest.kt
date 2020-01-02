package com.example.collectionlabtest.espresso.ex7dialogfragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode

@RunWith(AndroidJUnit4ClassRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class SampleFragmentTest {

    @Test
    fun lauchFragmentAndVerifyUi() {
        val scenario = launchFragmentInContainer<SampleFragment>()

        onView(withId(R.id.textView)).check(matches(withText(R.string.hello_fragment)))
    }
}