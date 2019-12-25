package com.example.collectionlabtest.ex1

import com.example.collectionlabtest.ex1.MainActivityTestEx1
import com.example.collectionlabtest.ex1.SecondActivityTestEx1
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTestEx1::class,
    SecondActivityTestEx1::class
)
class ActivityTestSuite {

}