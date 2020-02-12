package com.example.collectionlabtest.tdd.networking

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeService {
    @GET("/")
    @Headers(
        "Accept: application/json",
        "User-Agemt: Android Tutorial"
    )
    fun singleRandomDadJoke(): Single<DadJokeApiResponse>
}