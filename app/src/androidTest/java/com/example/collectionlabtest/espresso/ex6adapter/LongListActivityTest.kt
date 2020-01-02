package com.example.collectionlabtest.espresso.ex6adapter

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LongListActivityTest {
    private val TEXT_ITEM_30 = "item: 30"

    private val TEXT_ITEM_30_SELECTED = "30"

    private val TEXT_ITEM_60 = "item: 60"

    // Match the last item by matching its text.
    private val LAST_ITEM_ID = "item: 99"
    val activityScenario = ActivityScenario.launch(LongListActivity::class.java)


    /* @Test
     fun listItem_notDisplayed() {
         onView(withText(LAST_ITEM_ID)).check(doesNotExist())
     }*/

}