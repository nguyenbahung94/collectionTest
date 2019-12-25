package com.example.collectionlabtest.espresso.ex2.factory

import androidx.fragment.app.FragmentFactory
import com.example.collectionlabtest.espresso.ex2.view.DirectorsFragment
import com.example.collectionlabtest.espresso.ex2.view.MovieDetailFragment
import com.example.collectionlabtest.espresso.ex2.view.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}
