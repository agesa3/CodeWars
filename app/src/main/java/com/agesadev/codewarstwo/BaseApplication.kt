package com.agesadev.codewarstwo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplication : Application() {
    //setup timber
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}