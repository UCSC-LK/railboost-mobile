package org.ucsc.railboost_mobile.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DataStoreManager @Inject constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun getData(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        return dataStore.data.first()[dataStoreKey]
    }

    suspend fun setData(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preference -> preference[dataStoreKey] = value }
    }
}