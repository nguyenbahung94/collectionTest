package com.example.collectionlabtest.tdd.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionlabtest.R
import com.example.collectionlabtest.tdd.networking.DadJokeService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainJokeActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    private val dadJokeService by lazy {
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DadJokeService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_main)
    }
}