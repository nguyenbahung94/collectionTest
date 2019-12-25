package com.example.collectionlabtest.ex2

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class,
    DirectorsFragmentTest::class,
    StartActorsFragmentTest::class
)
class MoviesFragmentTestSuite