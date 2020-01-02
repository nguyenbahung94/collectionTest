package com.example.collectionlabtest.espresso.ex8idlingresource

import android.os.Handler
import androidx.annotation.Nullable
import com.example.collectionlabtest.espresso.ex8idlingresource.idlingresource.SimpleIdlingResource


internal object MessageDelayer {

    private val DELAY_MILLIS = 3000L

    internal interface DelayerCallback {
        fun onDone(text: String)
    }

    /**
     * Takes a String and returns it after [.DELAY_MILLIS] via a [DelayerCallback].
     * @param message the String that will be returned via the callback
     * @param callback used to notify the caller asynchronously
     */
    fun processMessage(
        message: String, callback: DelayerCallback?,
        @Nullable idlingResource: SimpleIdlingResource?
    ) {
        // The IdlingResource is null in production.
        if (idlingResource != null) {
            idlingResource!!.setIdleState(false)
        }

        // Delay the execution, return message via callback.
        val handler = Handler()
        handler.postDelayed(Runnable {
            if (callback != null) {
                callback.onDone(message)
                if (idlingResource != null) {
                    idlingResource!!.setIdleState(true)
                }
            }
        }, DELAY_MILLIS)
    }
}