package com.tsfrsapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_location"
)
class LocationEntity (
    @PrimaryKey val id: Int,
    var zoneID: Int,
    var zoneName: String,
    var districtID: Int,
    var districtName: String,
    var mandalID: Int,
    var mandalName: String,
)