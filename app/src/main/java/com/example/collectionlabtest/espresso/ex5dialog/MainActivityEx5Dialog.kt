package com.example.collectionlabtest.espresso.ex5dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.example.collectionlabtest.R
import kotlinx.android.synthetic.main.activity_main_ex5_dialog.*

class MainActivityEx5Dialog : AppCompatActivity(){

    private val TAG: String = "AppDebug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ex5_dialog)

        button_launch_dialog.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog(){
        MaterialDialog(this)
            .show {
                input (
                    waitForPositiveButton = true,
                    allowEmpty = false
                ){ dialog, name ->
                    setNameToTextView(name.toString())
                }
                title(R.string.text_enter_name)
                positiveButton(R.string.text_ok)
            }
    }

    private fun setNameToTextView(name: String){
        text_name.text = name
    }

}
