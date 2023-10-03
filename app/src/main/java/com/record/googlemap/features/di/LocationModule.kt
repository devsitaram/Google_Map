package com.record.googlemap.features.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.record.googlemap.features.domain.LocationService
import com.record.googlemap.features.data.LocationServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Singleton
    @Provides
    fun provideLocationClient(@ApplicationContext context: Context): LocationService =
        LocationServiceImpl(context, LocationServices.getFusedLocationProviderClient(context)
    )

//    @Singleton
//    @Provides
//    fun provideLocationClient(@ApplicationContext context: Context): LocationService {
//        return LocationServiceImpl(
//            context,
//            LocationServices.getFusedLocationProviderClient(context)
//        )
//    }
}