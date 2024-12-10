package com.ravimaurya.urjanext.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


val Context.datastore: DataStore<Preferences> by preferencesDataStore("user_preferences")

class UserDataPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    companion object{
        val LOGIN_SESSION = booleanPreferencesKey("login_session")
        val USERNAME = stringPreferencesKey("username")
        val PHONE_NUMBER = stringPreferencesKey("phone_number")
        val EMAIL = stringPreferencesKey("email")
    }

    val isLoggedIn: Flow<Boolean> = context.datastore.data.map { pref ->
        pref[LOGIN_SESSION] ?: false
    }


}