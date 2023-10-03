package com.record.googlemap.features.presentation

import com.google.android.gms.maps.model.LatLng


// To simplify, I've added ViewState and PermissionEvent in the same file.
// Ideally, it's better to have them in separate files
sealed interface ViewState {
    object Loading : ViewState
    data class Success(val location: LatLng?) : ViewState
    object RevokedPermissions : ViewState
}

sealed interface PermissionEvent {
    object Granted : PermissionEvent
    object Revoked : PermissionEvent
}