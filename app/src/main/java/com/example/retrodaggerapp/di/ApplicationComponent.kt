package com.example.retrodaggerapp.di

import android.content.Context
import com.example.retrodaggerapp.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkConnection::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)


}