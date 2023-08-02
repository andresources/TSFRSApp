package com.tsfrsapp.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsfrsapp.data.LocationModel
import com.tsfrsapp.data.local.LocationEntity
import com.tsfrsapp.data.repository.LocationRepo
import com.tsfrsapp.di.DefaultDispatcher
import com.tsfrsapp.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(private val repo: LocationRepo,@IoDispatcher private val ioDispatcher: CoroutineDispatcher) : ViewModel(){
    fun getAllLocations() : Flow<List<LocationModel>> =
        repo.getAllZones()
    fun insertLocation(locationModel: LocationModel) : Flow<String> = flow {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                var location = LocationEntity(
                    id = locationModel.id,
                    zoneID = locationModel.zoneID,
                    zoneName = locationModel.zoneName,
                    districtID = locationModel.districtID,
                    districtName = locationModel.districtName,
                    mandalID = locationModel.mandalID,
                    mandalName = locationModel.mandalName
                )
                repo.insertLocationDetails(location)
            }
        }
        emit("Inserted Successfully.")
    }

}