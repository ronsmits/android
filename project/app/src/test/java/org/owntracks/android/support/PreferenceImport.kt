package org.owntracks.android.support

import android.content.Context
import android.content.res.Resources
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.owntracks.android.model.messages.MessageConfiguration
import org.owntracks.android.support.preferences.PreferencesStore

class PreferenceImport {
    private lateinit var mockResources: Resources
    private lateinit var mockContext: Context
    private lateinit var preferencesStore: PreferencesStore

    @Before
    fun createMocks() {
        mockResources = PreferencesGettersAndSetters.getMockResources()
        mockContext = mock {
            on { resources } doReturn mockResources
            on { packageName } doReturn javaClass.canonicalName
        }
        preferencesStore = InMemoryPreferencesStore()
    }

    @Test
    fun `given a configuration message, when importing to preferences, all the keys in the config should be added`() {
        val preferences = Preferences(mockContext, null, preferencesStore)
        val messageConfiguration = MessageConfiguration()
        messageConfiguration["autostartOnBoot"] = true
        messageConfiguration["host"] = "testhost"
        messageConfiguration["port"] = 1234
        preferences.importFromMessage(messageConfiguration)
        assertEquals(true, preferences.autostartOnBoot)
        assertEquals("testhost", preferences.host)
        assertEquals(1234, preferences.port)
    }

    @Test
    fun `given a configuration message with an entry value of null, when importing to preferences, the config value should be cleared`() {
        val preferences = Preferences(mockContext, null, preferencesStore)
        val messageConfiguration = MessageConfiguration()
        messageConfiguration["host"] = null
        preferences.host = "testHost"
        preferences.importFromMessage(messageConfiguration)
        assertEquals("", preferences.host)
    }

    @Test
    fun `given a configuration message with an invalid key, when importing to preferences, it should be ignored`() {
        val preferences = Preferences(mockContext, null, preferencesStore)
        val messageConfiguration = MessageConfiguration()
        messageConfiguration["Invalid"] = "invalid"
        preferences.importFromMessage(messageConfiguration)
        assertFalse(preferences.exportToMessage().keys.contains("Invalid"))
    }

    @Test
    fun `given a configuration message with a value of the wrong type, when importing to preferences, it should be ignored`() {
        val preferences = Preferences(mockContext, null, preferencesStore)
        val messageConfiguration = MessageConfiguration()
        messageConfiguration["host"] = 4
        preferences.importFromMessage(messageConfiguration)
        assertEquals("", preferences.host)
    }
}