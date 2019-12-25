package com.example.collectionlabtest.espresso.ex2

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import com.example.collectionlabtest.espresso.ex2.factory.MovieFragmentFactory
import com.example.collectionlabtest.espresso.ex2.view.DirectorsFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest {

    @Test
    fun test_isDirectorsListVisible() {

        //setup
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)

        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //verify

        Espresso.onView(withId(R.id.directors_text)).check(
            matches(
                withText(
                    DirectorsFragment.stringBuilderForDirectors(directors)
                )
            )
        )


    }
}