package com.dmndev.mycv.di

import com.dmndev.mycv.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity() : MainActivity
}