package com.example.retrodaggerapp

import android.app.Application
import com.example.retrodaggerapp.di.ApplicationComponent
import com.example.retrodaggerapp.di.DaggerApplicationComponent


class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

         applicationComponent = DaggerApplicationComponent.builder().build()

    }
}