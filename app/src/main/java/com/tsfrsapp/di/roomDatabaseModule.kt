package com.tsfrsapp.di

import android.content.Context
import androidx.room.Room
import com.tsfrsapp.data.local.AppDatabase
import com.tsfrsapp.data.local.LocationDao
import com.tsfrsapp.data.repository.LocationRepo
import com.tsfrsapp.data.repository.LocationRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object roomDatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) :  AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "tsfrs.db"
    ).build()

    @Provides
    @Singleton
    fun provideLocationDao(appDatabase: AppDatabase) : LocationDao = appDatabase.getLocationDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule{
    @Binds
    @Singleton
    abstract fun bindLocation(locationRepo: LocationRepoImpl) : LocationRepo
}

