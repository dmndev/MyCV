package com.dmndev.mycv

import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.model.realm.PersonWrapper
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.realm.RealmModel


interface MyCVContract {

    interface RestRepository
    interface LocalRepository {
        fun <T : RealmModel> get(type: Class<T>) : T?
        fun <T : RealmModel> getList(type: Class<T>) : List<T>
        fun getObservable(type: Class<Person>) : Observable<PersonWrapper>
        fun <T : RealmModel> getObservableList(type: Class<T>) : Observable<List<T>>
        fun <T> save(obj: T)
    }

    interface MyCVRepository {
        fun updatePerson()
        fun updateExperience()
        fun updateKnowledge()
        fun getPerson() : Observable<PersonWrapper>
        fun getExperience() : Observable<List<Experience>>
        fun getKnowledge() : Observable<List<Knowledge>>
    }
}