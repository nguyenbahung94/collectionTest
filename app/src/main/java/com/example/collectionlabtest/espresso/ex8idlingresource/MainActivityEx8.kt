package com.example.collectionlabtest.espresso.ex8idlingresource

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.IdlingResource
import com.example.collectionlabtest.R
import com.example.collectionlabtest.espresso.ex8idlingresource.idlingresource.SimpleIdlingResource


class MainActivityEx8 : AppCompatActivity(), View.OnClickListener, MessageDelayer.DelayerCallback {

    // The TextView used to display the message inside the Activity.
    private var mTextView: TextView? = null

    // The EditText where the user types the message.
    private var mEditText: EditText? = null

    // The Idling Resource which will be null in production.
    @Nullable
    private var mIdlingResource: SimpleIdlingResource? = null

    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    val idlingResource: IdlingResource
        @VisibleForTesting
        get() {
            if (mIdlingResource == null) {
                mIdlingResource = SimpleIdlingResource()
            }
            return mIdlingResource!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_ex8_idling)

        // Set the listeners for the buttons.
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)

        mTextView = findViewById<View>(R.id.textToBeChanged) as TextView?
        mEditText = findViewById<View>(R.id.editTextUserInput) as EditText?
    }

    override fun onClick(view: View) {
        // Get the text from the EditText view.
        val text = mEditText!!.text.toString()

        if (view.id === R.id.changeTextBt) {
            // Set a temporary text.
            mTextView!!.setText(R.string.waiting_msg)
            // Submit the message to the delayer.
            MessageDelayer.processMessage(text, this, mIdlingResource)
        }
    }

    override fun onDone(text: String) {
        // The delayer notifies the activity via a callback.
        mTextView!!.text = text
    }
}