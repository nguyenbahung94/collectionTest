package com.example.collectionlabtest.espresso.ex1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionlabtest.R
import kotlinx.android.synthetic.main.activity_second_ex1.*


class SecondActivityEx1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_ex1)

        button_back.setOnClickListener {
            onBackPressed()
        }
    }
}