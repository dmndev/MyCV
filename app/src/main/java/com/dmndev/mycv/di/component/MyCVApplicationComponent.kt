package com.dmndev.mycv.di.component

import com.dmndev.mycv.MainActivity
import com.dmndev.mycv.MyCVApplication
import com.dmndev.mycv.di.*
import com.dmndev.mycv.di.MyCVApplicationModule
import com.dmndev.mycv.model.repository.LocalRepository
import com.dmndev.mycv.ui.experience.ExperienceFragment
import com.dmndev.mycv.ui.experience.ExperienceViewModel
import com.dmndev.mycv.ui.home.HomeViewModel
import com.dmndev.mycv.ui.knowledge.KnowledgeFragment
import com.dmndev.mycv.ui.knowledge.KnowledgeListAdapter
import com.dmndev.mycv.ui.knowledge.KnowledgeViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidInjectionModule::class,
        MyCVApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ActivityModule::class,
        FragmentModule::class]
)
@Singleton
interface MyCVApplicationComponent {

    fun inject(app: MyCVApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: ExperienceFragment)
    fun inject(fragment: KnowledgeFragment)
    fun inject(localRepository: LocalRepository)
    fun inject(experienceViewModel: ExperienceViewModel)
    fun inject(knowledgeViewModel: KnowledgeViewModel)
    fun inject(homeViewModel: HomeViewModel)
//    fun inject(localRepository: LocalRepository)

    @Component.Builder
    interface Builder {
        fun build(): MyCVApplicationComponent

        @BindsInstance
        fun applicationBind(app: MyCVApplication): Builder
    }
}