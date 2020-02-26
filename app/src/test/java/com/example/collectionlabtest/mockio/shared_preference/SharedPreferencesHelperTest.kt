package com.example.collectionlabtest.mockio.shared_preference

import android.content.SharedPreferences
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class SharedPreferencesHelperTest {

    private val TEST_NAME = "Test name"
    private val TEST_EMAIL = "test@email.com"
    private val TEST_DATE_OF_BIRTH = Calendar.getInstance().apply { set(1980, 1, 1) }

    private lateinit var sharedPreferenceEntry: SharedPreferenceEntry
    private lateinit var mockSharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var mockBrokenSharedPreferencesHelper: SharedPreferencesHelper

    @Mock
    private lateinit var mockSharedPreferences: SharedPreferences
    @Mock
    private lateinit var mockBrokenSharedPreferences: SharedPreferences
    @Mock
    private lateinit var mockEditor: SharedPreferences.Editor
    @Mock
    private lateinit var mockBrokenEditor: SharedPreferences.Editor


    @Before
    fun initMocks() {
        sharedPreferenceEntry = SharedPreferenceEntry(TEST_NAME, TEST_DATE_OF_BIRTH, TEST_EMAIL)

    }

    @Test
    fun sharedPreferencesHelper_SaveAndReadPersonalInformation() {
        mockSharedPreferencesHelper = createMockSharedPreference()
        mockBrokenSharedPreferencesHelper = createBrokenMockSharedPreference()
        // Save the personal information to SharedPreferences
        assertTrue(mockSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry))

        // Read personal information from SharedPreferences
        val savedEntry = mockSharedPreferencesHelper.getPersonalInfo()

// Make sure both written and retrieved personal information are equal.
        assertEquals(sharedPreferenceEntry.name, savedEntry.name)
        assertEquals(sharedPreferenceEntry.dateOfBirth, savedEntry.dateOfBirth)
        assertEquals(sharedPreferenceEntry.email, savedEntry.email)
    }

    @Test
    fun sharedPreferencesHelper_SavePersonalInformationFailed_ReturnsFalse() {
        mockBrokenSharedPreferencesHelper = createBrokenMockSharedPreference()
        // Read personal information from a broken SharedPreferencesHelper
        assertFalse(mockBrokenSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry))
    }

    private fun createMockSharedPreference(): SharedPreferencesHelper {
        // Mocking reading the SharedPreferences as if mockSharedPreferences was previously written
        // correctly.
        Mockito.`when`(
            mockSharedPreferences.getString(
                Matchers.eq(SharedPreferencesHelper.KEY_NAME),
                Matchers.anyString()
            )
        ).thenReturn(TEST_NAME)
        Mockito.`when`(
            mockSharedPreferences.getString(
                Matchers.eq(SharedPreferencesHelper.KEY_EMAIL),
                Matchers.anyString()
            )
        ).thenReturn(TEST_EMAIL)
        Mockito.`when`(
            mockSharedPreferences.getLong(
                Matchers.eq(SharedPreferencesHelper.KEY_DOB),
                Matchers.anyLong()
            )
        ).thenReturn(TEST_DATE_OF_BIRTH.timeInMillis)

        /* given(mockSharedPreferences.getString(Matchers.eq(SharedPreferencesHelper.KEY_NAME), Matchers.anyString()))
         given(mockSharedPreferences.getString(Matchers.eq(SharedPreferencesHelper.KEY_EMAIL), Matchers.anyString()))
         given(mockSharedPreferences.getLong(Matchers.eq(SharedPreferencesHelper.KEY_DOB), Matchers.anyLong()))*/
        // given(mockEditor.commit()).willReturn(true)


        Mockito.`when`(mockEditor.commit()).thenReturn(true)
        // Return the MockEditor when requesting it.

        // given(mockSharedPreferences.edit()).willReturn(mockEditor)

        Mockito.`when`(mockSharedPreferences.edit()).thenReturn(mockEditor)
        return SharedPreferencesHelper(mockSharedPreferences)
    }

    /**
     * Creates a mocked SharedPreferences that fails when writing.
     */
    private fun createBrokenMockSharedPreference(): SharedPreferencesHelper {
        // Mocking a commit that fails.
        given(mockBrokenEditor.commit()).willReturn(false)
// Return the broken MockEditor when requesting it.
        given(mockBrokenSharedPreferences.edit()).willReturn(mockBrokenEditor)
        return SharedPreferencesHelper(mockBrokenSharedPreferences)
    }
}