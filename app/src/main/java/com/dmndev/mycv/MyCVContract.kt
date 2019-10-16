package com.dmndev.mycv

import io.reactivex.Observable
import io.realm.RealmModel


interface MyCVContract {

    interface RestRepository
    interface LocalRepository {
        fun <T> get(type: Class<RealmModel>) : T?
        fun <T> getList(type: Class<RealmModel>) : List<T>
        fun <T> getObservable(type: Class<RealmModel>) : Observable<T>
        fun <T> getObservableList(type: Class<RealmModel>) : Observable<List<T>>
    }
}