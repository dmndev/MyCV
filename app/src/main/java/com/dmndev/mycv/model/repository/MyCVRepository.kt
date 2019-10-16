package com.dmndev.mycv.model.repository

import com.dmndev.mycv.MyCVContract
import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


open class MyCVRepository(
    private val localRepository: LocalRepository,
    private val remoteRepository: RestRepository
) : MyCVContract.MyCVRepository {
    override fun updatePerson(): Observable<Person> {
        return remoteRepository.getPerson()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it //save
            }
    }

    override fun updateExperience(): Completable {
        return Completable.fromObservable(remoteRepository.getExperiences()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                localRepository.save(it)
            }
        )
    }

    override fun updateKnowledge(): Completable {
        return Completable.fromObservable(remoteRepository.getKnowledge()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                localRepository.save(it)
            }
        )
    }

    override fun getPerson(): Observable<Person> {
        return localRepository.getObservable<Person>(Person::class.java)
    }

    override fun getExperience(): Observable<List<Experience>> {
        return localRepository.getObservableList<Experience>(Experience::class.java)
    }

    override fun getKnowledge(): Observable<List<Knowledge>> {
        return localRepository.getObservableList<Knowledge>(Knowledge::class.java)
    }
}