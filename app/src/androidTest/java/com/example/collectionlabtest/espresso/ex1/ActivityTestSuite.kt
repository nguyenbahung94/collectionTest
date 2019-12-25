package com.example.collectionlabtest.espresso.ex1

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTestEx1::class,
    SecondActivityTestEx1::class
)
class ActivityTestSuite {

}