package com.dmndev.mycv

import android.app.Application
import com.dmndev.mycv.di.Injector
import com.dmndev.mycv.di.component.DaggerMyCVApplicationComponent
import com.dmndev.mycv.di.component.MyCVApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MyCVApplication : Application(), HasAndroidInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    private var component: MyCVApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        Injector.initializeComponent(this)
        Injector.getComponent().inject(this)
    }
}