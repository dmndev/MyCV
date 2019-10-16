package com.dmndev.mycv.di

import com.dmndev.mycv.ui.dashboard.ExperienceFragment
import com.dmndev.mycv.ui.home.HomeFragment
import com.dmndev.mycv.ui.notifications.KnowledgeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeExperienceFragmentModule() : ExperienceFragment

    @ContributesAndroidInjector
    internal abstract fun contributeKnowledgeFragmentModule() : KnowledgeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragmentModule() : HomeFragment
}