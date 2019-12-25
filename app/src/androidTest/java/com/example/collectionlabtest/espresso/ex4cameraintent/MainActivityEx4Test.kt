package com.example.collectionlabtest.espresso.ex4cameraintent

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEx4Test {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivityCameraEx4::class.java)

    @Test
    fun test_cameraIntent_isBitmapSetToImageView() {
        //given
        val activityResult = createGalleryPickActivityResultSub()
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        )
        intentding(expectedIntent)/
    }

    private fun createGalleryPickActivityResultSub(): Instrumentation.ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA, BitmapFactory.decodeResource(
                intentsTestRule.activity.resources,
                R.drawable.ic_launcher_background
            )
        )
        val resultData = Intent()
        resultData.putExtras(bundle)
        return Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
    }
}