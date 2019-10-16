package com.dmndev.mycv

import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.realm.RealmModel


interface MyCVContract {

    interface RestRepository
    interface LocalRepository {
        fun <T> get(type: Class<RealmModel>) : T?
        fun <T> getList(type: Class<RealmModel>) : List<T>
        fun <T> getObservable(type: Class<RealmModel>) : Observable<T>
        fun <T> getObservableList(type: Class<RealmModel>) : Observable<List<T>>
        fun <T> save(obj: T)
    }

    interface MyCVRepository {
        fun updatePerson() : Observable<Person>
        fun updateExperience() : Completable
        fun updateKnowledge() : Completable
        fun getPerson() : Observable<Person>
        fun getExperience() : Observable<List<Experience>>
        fun getKnowledge() : Observable<List<Knowledge>>
    }
}