package com.example.collectionlabtest.tdd.domain

import com.example.collectionlabtest.tdd.networking.DadJokeService
import io.reactivex.Single

class GetRandomDadjoke(private val dadJokeService: DadJokeService) {


    fun execute(): Single<DadJokeModel> {
        return dadJokeService.singleRandomDadJoke().map { DadJokeModel("name") }
    }
}