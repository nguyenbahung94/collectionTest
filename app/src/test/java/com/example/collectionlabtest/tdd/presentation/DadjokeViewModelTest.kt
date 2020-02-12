package com.example.collectionlabtest.tdd.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.collectionlabtest.R
import com.example.collectionlabtest.tdd.common.Stringloader
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DadjokeViewModelTest {


    @get:Rule
    val viewmodelRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var stringloader: Stringloader

    private lateinit var subject: DadjokeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every { stringloader.get(R.string.app_name) } returns "right"
        subject = DadjokeViewModel(stringloader)
    }

    @Test
    fun `given a new subject, when observing on state`() {
        val actual = subject.state.value!!

        assertThat(actual.state).isEqualTo("right")
    }
}