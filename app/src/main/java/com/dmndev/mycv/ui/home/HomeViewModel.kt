package com.dmndev.mycv.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.di.Injector
import com.dmndev.mycv.model.*
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.model.realm.PersonWrapper
import com.dmndev.mycv.model.repository.MyCVRepository
import com.dmndev.mycv.utils.DisposableManager
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class HomeViewModel : ViewModel() {

    @Inject
    lateinit var myCVRepository: MyCVRepository
    @Inject
    lateinit var disposableManager: DisposableManager

    private val _person = MutableLiveData<Person>().apply {
        value = Person()
    }

    var person: LiveData<Person> = _person

    init {
        Injector.getComponent().inject(this)
        updateAndGetPerson()
    }

    private fun updateAndGetPerson() {
        myCVRepository.updatePerson()

        myCVRepository.getPerson()
            .subscribeWith(object : DisposableObserver<PersonWrapper>() {
                override fun onComplete() {
                }

                override fun onNext(t: PersonWrapper) {
                        _person.apply {
                            value = t.person
                        }
                }

                override fun onError(e: Throwable) {
                }
            }).addTo(disposableManager.compositeDisposable)
    }
}