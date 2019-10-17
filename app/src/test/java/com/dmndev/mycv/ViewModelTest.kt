package com.dmndev.mycv

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.repository.MyCVRepository
import com.dmndev.mycv.ui.experience.ExperienceViewModel
import io.reactivex.Observable
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.Scheduler.Worker
import io.reactivex.disposables.Disposable
import io.reactivex.Scheduler
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import android.R.string.no
import android.R.attr.name
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dmndev.mycv.di.*
import com.dmndev.mycv.di.component.MyCVApplicationComponent
import dagger.android.AndroidInjectionModule
import io.reactivex.schedulers.Schedulers
import it.cosenonjaviste.daggermock.DaggerMockRule
import org.junit.*


@RunWith(JUnit4::class)
class ViewModelTest {

    lateinit var experienceViewModel: ExperienceViewModel

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        val immediate = object : Scheduler() {
            override fun scheduleDirect(@NonNull run: Runnable, delay: Long, @NonNull unit: TimeUnit): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false)
            }
        }
        RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
    }

    @Test
    fun updateExperience(){
        val experience = Experience()
        experience.name = "Test Experience"
        experience.description = "Test Description"
    }


}