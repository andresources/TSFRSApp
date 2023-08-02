package com.tsfrsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocationEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getLocationDao() : LocationDao
}