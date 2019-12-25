package com.example.collectionlabtest.espresso.ex3AboutIntent

import android.app.Activity.RESULT_OK
import android.app.Instrumentation.ActivityResult
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.collectionlabtest.R
import com.example.collectionlabtest.espresso.ex3Intent.MainActivityEx3
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTestEx3 {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivityEx3::class.java)

    @Test
    fun test_validateGalleryIntent() {
        //given
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        )
        val activityResult = createGalleryPickActivityResultSub()
        intending(expectedIntent).respondWith(activityResult)

        //execute and verify
        Espresso.onView(withId(R.id.button_open_gallery)).perform(click())
        intended(expectedIntent)

    }

    private fun createGalleryPickActivityResultSub(): ActivityResult {
        val resource = InstrumentationRegistry.getInstrumentation().context.resources as Resources
        val imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resource.getResourcePackageName(R.drawable.ic_launcher_background)
                    + "/" + resource.getResourceTypeName(R.drawable.ic_launcher_background) + "/" +
                    resource.getResourceEntryName(R.drawable.ic_launcher_background)

        )
        val resultIntent = Intent()
        resultIntent.data = imageUri
        return ActivityResult(RESULT_OK, resultIntent)
    }

}