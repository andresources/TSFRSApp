package com.tsfrsapp.data.repository

import com.tsfrsapp.data.LocationModel
import com.tsfrsapp.data.local.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocationRepo {
    fun getAllZones() : Flow<List<LocationModel>>
    suspend fun insertLocationDetails(location: LocationEntity)
}