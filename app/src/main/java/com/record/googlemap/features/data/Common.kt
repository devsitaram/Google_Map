package com.record.googlemap.features.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState

// from main activity
//fun Context.hasLocationPermission(): Boolean {
//    return ContextCompat.checkSelfPermission(
//        this,
//        Manifest.permission.ACCESS_FINE_LOCATION // DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
//    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
//        this,
//        Manifest.permission.ACCESS_COARSE_LOCATION // ACCESS_COARSE_LOCATION
//    ) == PackageManager.PERMISSION_GRANTED
//}

suspend fun CameraPositionState.centerOnLocation(location: LatLng) = animate(
    update = CameraUpdateFactory.newLatLngZoom(location, 15f),
    durationMs = 1500
)

// from compose
fun hasLocationPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION // DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION // ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}