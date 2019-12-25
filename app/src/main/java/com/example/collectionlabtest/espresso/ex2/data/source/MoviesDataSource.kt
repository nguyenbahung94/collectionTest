package com.example.collectionlabtest.espresso.ex2.data.source

import com.example.collectionlabtest.espresso.ex2.data.Movie

interface MoviesDataSource {
    fun getMovie(movieId: Int): Movie?
}