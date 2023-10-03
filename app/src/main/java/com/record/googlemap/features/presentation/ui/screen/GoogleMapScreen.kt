package com.record.googlemap.features.presentation.ui.screen

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.record.googlemap.MainScreen
import com.record.googlemap.RationaleAlert
import com.record.googlemap.centerOnLocation
import com.record.googlemap.features.data.hasLocationPermission
import com.record.googlemap.features.presentation.GoogleMapViewModel
import com.record.googlemap.features.presentation.PermissionEvent
import com.record.googlemap.features.presentation.ViewState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun GoogleMapViewScreen(
    locationViewModel: GoogleMapViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    val viewState by locationViewModel.viewState.collectAsStateWithLifecycle()

//    LaunchedEffect(!hasLocationPermission(context)) {
//        permissionState.launchMultiplePermissionRequest()
//    }

    when {
        permissionState.allPermissionsGranted -> {
            LaunchedEffect(Unit) {
                locationViewModel.handle(PermissionEvent.Granted)
            }
        }

        permissionState.shouldShowRationale -> {
            RationaleAlert(onDismiss = { }) {
                permissionState.launchMultiplePermissionRequest()
            }
        }

        !permissionState.allPermissionsGranted && !permissionState.shouldShowRationale -> {
            LaunchedEffect(Unit) {
                locationViewModel.handle(PermissionEvent.Revoked)
            }
        }
    }

    with(viewState) {
//        when (this) {
//            ViewState.Loading -> {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator()
//                }
//            }
//
//            ViewState.RevokedPermissions -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(24.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "We need permissions to use this app")
//                    Button(
//                        onClick = {
////                            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
////                            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)) //Settings.ACTION_LOCATION_SOURCE_SETTINGS
//                        },
//                        enabled = !hasLocationPermission(context)
//                    ) {
//                        if (hasLocationPermission(context)) CircularProgressIndicator(
//                            modifier = Modifier.size(14.dp),
//                            color = Color.White
//                        )
//                        else Text("Settings")
//                    }
//                }
//            }
//
//            is ViewState.Success -> {
//                val currentLoc =
//                    LatLng(
//                        location?.latitude ?: 0.0,
//                        location?.longitude ?: 0.0
//                    )
//                val cameraState = rememberCameraPositionState()
//
//                LaunchedEffect(key1 = currentLoc) {
//                    cameraState.centerOnLocation(currentLoc)
//                }
//
//                MainScreen(
//                    currentPosition = LatLng(
//                        currentLoc.latitude,
//                        currentLoc.longitude
//                    ),
//                    cameraState = cameraState
//                )
//            }
//        }
    }
}
