package com.dmndev.mycv.di

import com.dmndev.mycv.ui.experience.ExperienceFragment
import com.dmndev.mycv.ui.home.HomeFragment
import com.dmndev.mycv.ui.knowledge.KnowledgeFragment
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