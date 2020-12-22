package com.aligkts.daggerhiltsample.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 22.12.2020
 */
@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideUserName() = USER_NAME

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.createDataStore(name = "app_preferences")

    companion object {
        private const val SHARED_PREFERENCES_FILE_NAME = "app_preferences"
        private const val USER_NAME = "Ali Goktas"
    }
}