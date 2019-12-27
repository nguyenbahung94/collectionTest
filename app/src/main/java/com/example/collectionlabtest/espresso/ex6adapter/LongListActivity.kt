package com.example.collectionlabtest.espresso.ex6adapter

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import com.example.collectionlabtest.R


class LongListActivity : Activity() {

    private val data = ArrayList<Map<String, Any>>()

    var layoutIf: LayoutInflater? = null

    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.list_activity_ex6adapter)
        populateData()

        val listView = findViewById<View>(R.id.list) as ListView
        val from = arrayOf(ROW_TEXT, ROW_ENABLED)
        val to = intArrayOf(R.id.rowContentTextView, R.id.rowToggleButton)
        layoutIf = layoutInflater

        // Create the adapter for the list.
        val adapter = LongListAdapter(from, to)

        // Send the data to the list.
        listView.adapter = adapter
    }

    private fun populateData() {
        for (i in 0 until NUMBER_OF_ITEMS) {
            data.add(makeItem(i))
        }
    }

    private inner class LongListAdapter(from: Array<String>, to: IntArray) : SimpleAdapter(
        this@LongListActivity,
        this@LongListActivity.data,
        R.layout.list_item_ex6adapter,
        from,
        to
    ) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            // Inflate list items.
            if (null == convertView) {
                convertView = layoutIf!!.inflate(R.layout.list_item_ex6adapter, null)
            }

            convertView!!.setOnClickListener {
                (findViewById<View>(R.id.selection_row_value) as TextView).text =
                    position.toString()
            }

            return super.getView(position, convertView, parent)
        }
    }

    companion object {

        @VisibleForTesting
         val ROW_TEXT = "ROW_TEXT"

        @VisibleForTesting
         val ROW_ENABLED = "ROW_ENABLED"

        @VisibleForTesting
         val NUMBER_OF_ITEMS = 100

        @VisibleForTesting
         val ITEM_TEXT_FORMAT = "item: %d"

        @VisibleForTesting
         fun makeItem(forRow: Int): Map<String, Any> {
            val dataRow = hashMapOf<String, Any>()
            dataRow[ROW_TEXT] = String.format(ITEM_TEXT_FORMAT, forRow)
            dataRow[ROW_ENABLED] = forRow == 1
            return dataRow
        }
    }
}
