package com.dmndev.mycv.model.repository

import com.dmndev.mycv.MyCVContract
import com.dmndev.mycv.di.Injector
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import javax.inject.Inject


class LocalRepository @Inject constructor() : MyCVContract.LocalRepository{

    @Inject
    lateinit var realm : Realm

    init {
        Injector.getComponent().inject(this)
    }

    override fun <T : RealmModel> get(type: Class<T>): T? {
        val findFirst : RealmModel? = realm.where(type).findFirst()
        if(findFirst == null) {
            return findFirst as T
        }

         return realm.copyFromRealm(realm.where(type).findFirst()) as T
    }

    override fun <T : RealmModel> getList(type: Class<T>): List<T> {
        return realm.where(type).findAll() as List<T>
    }

    override fun <T : RealmModel> getObservable(type: Class<T>): Observable<T?> {
        return realm.where(type)
            .findAllAsync()
            .asFlowable()
            .filter { it.isLoaded }
            .map { if(it.isNotEmpty()) it[0] else null }
            .toObservable()
    }

    override fun <T : RealmModel> getObservableList(type: Class<T>): Observable<List<T>> {
        return realm.where(type)
            .findAllAsync()
            .asFlowable()
            .filter { it.isLoaded }
            .map {
                it as List<T>
            }.toObservable()
    }

    override fun <T> save(obj: T) {
        realm.executeTransactionAsync{
            saveProperType(obj, it)
        }
    }

    private fun <T> saveProperType(obj: T, realm: Realm){
        when(obj){
            is List<*> -> realm.copyToRealmOrUpdate(obj as List<RealmObject>)
            is RealmObject -> realm.copyToRealmOrUpdate(obj as RealmObject)
            else -> throw UnsupportedOperationException("Not proper realm object")
        }
    }
}