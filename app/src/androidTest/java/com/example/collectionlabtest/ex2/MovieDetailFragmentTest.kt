package com.example.collectionlabtest.ex2

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import com.example.collectionlabtest.espresso.ex2.data.DummyMovies.THE_RUNDOWN
import com.example.collectionlabtest.espresso.ex2.factory.MovieFragmentFactory
import com.example.collectionlabtest.espresso.ex2.view.MovieDetailFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun test_isMovieDataVisible() {
        //setup
        val movie = THE_RUNDOWN
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario =
            launchFragmentInContainer<MovieDetailFragment>(
                fragmentArgs = bundle,
                factory = fragmentFactory
            )

        Espresso.onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        Espresso.onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }

}
