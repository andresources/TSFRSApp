package com.tsfrsapp.data

import com.tsfrsapp.data.local.LocationEntity

fun LocationEntity.toExternal() = LocationModel(
    id = id,
    zoneID = zoneID,
    zoneName = zoneName,
    districtID = districtID,
    districtName = districtName,
    mandalID = mandalID,
    mandalName = mandalName
)

fun LocationModel.toLocal() = LocationEntity(
    id = id,
    zoneID = zoneID,
    zoneName = zoneName,
    districtID = districtID,
    districtName = districtName,
    mandalID = mandalID,
    mandalName = mandalName
)

@JvmName("internalToExternal")
fun List<LocationEntity>.toExternal() = map(LocationEntity::toExternal)