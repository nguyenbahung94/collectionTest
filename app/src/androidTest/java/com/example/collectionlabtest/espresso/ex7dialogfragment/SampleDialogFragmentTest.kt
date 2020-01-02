package com.example.collectionlabtest.espresso.ex7dialogfragment

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode


@RunWith(AndroidJUnit4ClassRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class SampleDialogFragmentTest {
    @Test
    fun lauchDialogFragmentAndVerifyUI() {
        val dialogScenario = launchFragment<SampleDialogFragment>()

        dialogScenario.onFragment { fragment ->
            this.run {
                assertThat(fragment.dialog).isNotNull()
                assertThat(fragment.requireDialog().isShowing).isTrue()
            }
        }

        onView(withId(R.id.textView)).inRoot(isDialog())
            .check(matches(withText(R.string.hello_fragment)))
    }

    @Test
    fun launchDialogFragmentEmbeddedToHostActivityAndVerifyUI() {
        // Use launchFragmentInContainer to inflate a dialog fragment's view into Activity's content view.
        val scenario = launchFragmentInContainer<SampleDialogFragment>()

        scenario.onFragment { fragment ->
            // Dialog is not created because you use launchFragmentInContainer and the view is inflated
            // into the Activity's content view.
            assertThat(fragment.dialog).isNull()
        }
        onView(withId(R.id.textView))
            .check(matches(withText("I am a fragment")));
    }
}