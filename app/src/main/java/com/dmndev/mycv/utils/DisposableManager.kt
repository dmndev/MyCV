package com.dmndev.mycv.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DisposableManager @Inject constructor() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun add(disposable: Disposable) {
        compositeDisposable!!.add(disposable)
    }

    fun dispose() {
        compositeDisposable!!.dispose()
    }
}