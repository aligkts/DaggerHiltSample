package com.aligkts.daggerhiltsample.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import com.aligkts.daggerhiltsample.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userName: String

    @Inject
    lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "UserName: $userName", Toast.LENGTH_LONG).show()
    }

    suspend fun storeUserName() {
        dataStore.edit { preferences ->
            preferences[KEY_USER_NAME] = userName
        }
    }

    companion object{
        val KEY_USER_NAME = preferencesKey<String>("user_name")
    }
}