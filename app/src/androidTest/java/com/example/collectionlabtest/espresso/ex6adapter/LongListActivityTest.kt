package com.example.collectionlabtest.espresso.ex6adapter

import androidx.test.espresso.DataInteraction
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.collectionlabtest.R
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class LongListActivityTest {
    private val TEXT_ITEM_30 = "item: 30"

    private val TEXT_ITEM_30_SELECTED = "30"

    private val TEXT_ITEM_60 = "item: 60"

    // Match the last item by matching its text.
    private val LAST_ITEM_ID = "item: 99"
    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test. This is a
     * replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @get:Rule
    var rule = ActivityScenarioRule(LongListActivity::class.java)

    @Test
    fun lastItem_notDisplayed() {
        // Last item should not exist if the list wasn't scrolled down.
        onView(withText(LAST_ITEM_ID)).check(doesNotExist())
    }

    /**
     * Check that the item is created. onData() takes care of scrolling.
     */
    @Test
    fun list_scrolls() {
        onRow(LAST_ITEM_ID).check(matches(isCompletelyDisplayed()))
    }

    /**
     * Clicks on a row and checks that the activity detected the click.
     */
    @Test
    fun row_Click() {
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click())

        onView(withId(R.id.selection_row_value)).check(
            matches(
                withText(
                    TEXT_ITEM_30_SELECTED
                )
            )
        )
    }

    /**
     * Checks that a toggle button is checked after clicking on it.
     */

    @Test
    fun toggle_Click() {
        // Click on a toggle button.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).perform(click())

        // Check that the toggle button is checked.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).check(matches(isChecked()))
    }

    /**
     * Make sure that clicking on the toggle button doesn't trigger a click on the row.
     */

    @Test
    fun toggle_ClickDoesntPrepagete() {
        // Click on one of the rows.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click())

        // Click on the toggle button, in a different row.
        onRow(TEXT_ITEM_60).onChildView(withId(R.id.rowToggleButton)).perform(click())

        // Check that the activity didn't detect the click on the first column.
        onView(withId(R.id.selection_row_value)).check(matches(withText(TEXT_ITEM_30_SELECTED)))
    }


    companion object {
        fun onRow(str: String): DataInteraction {
            return onData(hasEntry(equalTo(LongListActivity.ROW_TEXT), `is`(str)))

        }
    }

}