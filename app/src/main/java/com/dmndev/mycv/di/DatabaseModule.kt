package com.dmndev.mycv.di

import android.content.Context
import com.dmndev.mycv.MyCVApplication
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(app: MyCVApplication) : Realm {
        Realm.init(app)
        val realmConfiguration = RealmConfiguration.Builder()
            .name("mycv.db")
            .deleteRealmIfMigrationNeeded()
            .build()

        return Realm.getInstance(realmConfiguration)
    }
}