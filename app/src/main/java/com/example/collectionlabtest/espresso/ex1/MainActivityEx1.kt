package com.example.collectionlabtest.espresso.ex1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionlabtest.R
import kotlinx.android.synthetic.main.activity_main_ex1.*

class MainActivityEx1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ex1)

        button_next_activity.setOnClickListener {
            val intent = Intent(this, SecondActivityEx1::class.java)
            startActivity(intent)
        }
    }

}