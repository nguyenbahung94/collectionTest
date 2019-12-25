package com.example.collectionlabtest.espresso.ex2

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import com.example.collectionlabtest.espresso.ex2.factory.MovieFragmentFactory
import com.example.collectionlabtest.espresso.ex2.view.StarActorsFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StartActorsFragmentTest {
    @Test
    fun test_isDirectorsListVisible() {

        //setup
        val startActors = arrayListOf(
            "Dwayne Johnson",
            "Seann William Scott",
            "Rosario Dawson",
            "Christopher Walken"
        )
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", startActors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //verify

        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(startActors)
                )
            )
        )


    }
}