package com.dmndev.mycv.di

import com.dmndev.mycv.MyCVApplication
import com.dmndev.mycv.di.component.DaggerMyCVApplicationComponent
import com.dmndev.mycv.di.component.MyCVApplicationComponent


object Injector {
    var myCVApplicationComponent: MyCVApplicationComponent? = null

    fun initializeComponent(app: MyCVApplication) {
        myCVApplicationComponent = DaggerMyCVApplicationComponent.builder()
            .applicationBind(app)
//            .databaseModule(DatabaseModule())
            .build()
    }

    fun getComponent() : MyCVApplicationComponent{
        return requireNotNull(myCVApplicationComponent)
    }


}