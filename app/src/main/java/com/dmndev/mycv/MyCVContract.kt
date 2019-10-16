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
        fun <T : RealmModel> get(type: Class<T>) : T?
        fun <T : RealmModel> getList(type: Class<T>) : List<T>
        fun <T : RealmModel> getObservable(type: Class<T>) : Observable<T>
        fun <T : RealmModel> getObservableList(type: Class<T>) : Observable<List<T>>
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