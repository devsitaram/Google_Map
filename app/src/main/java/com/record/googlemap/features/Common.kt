package com.record.googlemap.features

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun Context.hasLocationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_FINE_LOCATION // DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_COARSE_LOCATION // ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}
