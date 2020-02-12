package com.example.collectionlabtest.tdd.domain

import com.example.collectionlabtest.tdd.networking.DadJokeApiResponse
import com.example.collectionlabtest.tdd.networking.DadJokeService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetRandomDadjokeTest {

    private lateinit var subject: GetRandomDadjoke
    @RelaxedMockK
    private lateinit var dadJokeService: DadJokeService
    private val expectedDadJokeModel = DadJokeModel("this is my name")
    private val expectedError = java.lang.Exception("that joke was....")

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        subject = GetRandomDadjoke(dadJokeService)
    }

    @After
    fun tearDown() {
    }

    private fun givenAnUnSuccessfulNetWorkingCall() {
        every { dadJokeService.singleRandomDadJoke() } returns Single.error(expectedError)
    }

    private fun givenAnSuccessfulNetWorkingCall() {
        every { dadJokeService.singleRandomDadJoke() } returns Single.just(
            DadJokeApiResponse(
                "name",
                "joke",
                200
            )
        )
    }

    @Test
    fun `given an api error, when execute is called, an error should be emitted`() {
        givenAnUnSuccessfulNetWorkingCall()
        subject.execute().test()
            .assertNoValues()
            .assertNotComplete()
            .assertError(Throwable::class.java)
    }

    @Test
    fun `given a successful networking call, when execute is called, a dad joke should be emitted`() {
        givenAnSuccessfulNetWorkingCall()
        subject.execute().test()
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
    }

    @Test
    fun `given an unSuccessful net working call, when execute is called, the correct error is emitted`() {
        givenAnUnSuccessfulNetWorkingCall()
        subject.execute().test()
            .assertNoValues()
            .assertNotComplete()
            .assertError(expectedError)
    }

}