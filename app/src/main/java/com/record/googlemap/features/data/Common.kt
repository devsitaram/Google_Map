package com.record.googlemap.features.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

// from main activity
fun Context.hasLocationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_FINE_LOCATION // DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.ACCESS_COARSE_LOCATION // ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

// from compose
//fun hasLocationPermission(context: Context): Boolean {
//    return ContextCompat.checkSelfPermission(
//        context,
//        Manifest.permission.ACCESS_FINE_LOCATION // DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION
//    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
//        context,
//        Manifest.permission.ACCESS_COARSE_LOCATION // ACCESS_COARSE_LOCATION
//    ) == PackageManager.PERMISSION_GRANTED
//}