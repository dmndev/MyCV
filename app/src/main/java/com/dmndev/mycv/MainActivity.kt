package com.dmndev.mycv

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dmndev.mycv.di.Injector
import com.dmndev.mycv.model.repository.LocalRepository
import com.dmndev.mycv.utils.DisposableManager
import dagger.android.AndroidInjection
import io.realm.Realm
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var disposableManager: DisposableManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        disposableManager.dispose()
        super.onDestroy()
    }
}
