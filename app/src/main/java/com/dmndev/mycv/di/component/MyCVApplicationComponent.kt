package com.dmndev.mycv.di.component

import android.app.Application
import com.dmndev.mycv.MainActivity
import com.dmndev.mycv.MyCVApplication
import com.dmndev.mycv.di.ActivityModule
import com.dmndev.mycv.di.DatabaseModule
import com.dmndev.mycv.di.FragmentModule
import com.dmndev.mycv.di.MyCVApplicationModule
import com.dmndev.mycv.model.repository.LocalRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidInjectionModule::class,
        MyCVApplicationModule::class,
        DatabaseModule::class,
        ActivityModule::class,
        FragmentModule::class]
)
@Singleton
interface MyCVApplicationComponent {

    fun inject(app: MyCVApplication)
    fun inject(activity: MainActivity)
    fun inject(localRepository: LocalRepository)

    @Component.Builder
    interface Builder {
        fun build(): MyCVApplicationComponent

        @BindsInstance
        fun applicationBind(app: MyCVApplication): Builder
    }
}