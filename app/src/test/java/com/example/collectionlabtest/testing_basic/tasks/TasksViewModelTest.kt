package com.example.collectionlabtest.testing_basic.tasks

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TasksViewModelTest {

    /*@get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun  addNewTask_setsNewTaskEvent() {
        val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        taskViewModel.addNewTask()

        // Then the new task event is triggered
        val value = taskViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        try {
            afterObserve.invoke()

            // Don't wait indefinitely if the LiveData is not set.
            if (!latch.await(time, timeUnit)) {
                throw TimeoutException("LiveData value was never set.")
            }

        } finally {
            this.removeObserver(observer)
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }*/
}