package com.dmndev.mycv.model.repository

import android.util.Log
import com.dmndev.mycv.MyCVContract
import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.utils.DisposableManager
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


open class MyCVRepository @Inject constructor(
) : MyCVContract.MyCVRepository {

    @Inject
    lateinit var remoteRepository: RestRepository
    @Inject
    lateinit var localRepository: LocalRepository
    @Inject
    lateinit var disposableManager: DisposableManager

    override fun updatePerson() {
        remoteRepository.getPerson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<Person>() {
                override fun onSuccess(t: Person) {
                    localRepository.save(t)
                }

                override fun onError(e: Throwable) {
                }
            }).addTo(disposableManager.compositeDisposable)
    }

    override fun updateExperience() {
        remoteRepository.getExperiences()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Experience>>() {
                override fun onSuccess(t: List<Experience>) {
                    localRepository.save(t)
                }

                override fun onError(e: Throwable) {
                }
            }).addTo(disposableManager.compositeDisposable)
    }

    override fun updateKnowledge() {
        remoteRepository.getKnowledge()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Knowledge>>() {
                override fun onSuccess(t: List<Knowledge>) {
                    localRepository.save(t)
                }

                override fun onError(e: Throwable) {
                }
            }).addTo(disposableManager.compositeDisposable)
    }

    override fun getPerson(): Observable<Person?> {
        return localRepository.getObservable<Person>(Person::class.java)
    }

    override fun getExperience(): Observable<List<Experience>> {
        return localRepository.getObservableList<Experience>(Experience::class.java)
    }

    override fun getKnowledge(): Observable<List<Knowledge>> {
        return localRepository.getObservableList<Knowledge>(Knowledge::class.java)
    }
}