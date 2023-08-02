package com.tsfrsapp.data.repository

import com.tsfrsapp.data.LocationModel
import com.tsfrsapp.data.local.LocationDao
import com.tsfrsapp.data.local.LocationEntity
import com.tsfrsapp.data.toExternal
import com.tsfrsapp.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationRepoImpl @Inject constructor(private val locationDao: LocationDao,@DefaultDispatcher private val dd: CoroutineDispatcher) : LocationRepo {
    override fun getAllZones(): Flow<List<LocationModel>> = locationDao.getAllZones().map { locations ->
        withContext(dd){
            locations.toExternal()
        }
    }

    override suspend fun insertLocationDetails(location: LocationEntity) = withContext(dd) {
        locationDao.insertLocationDetails(location)
    }
}