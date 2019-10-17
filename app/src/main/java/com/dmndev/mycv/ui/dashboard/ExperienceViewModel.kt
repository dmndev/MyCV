package com.dmndev.mycv.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.di.Injector
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.model.repository.MyCVRepository
import com.dmndev.mycv.utils.DisposableManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ExperienceViewModel : ViewModel() {

    @Inject
    lateinit var myCVRepository: MyCVRepository
    @Inject
    lateinit var disposableManager: DisposableManager

    init {
        Injector.getComponent().inject(this)
        test()
    }

    fun test() {
        myCVRepository.updateExperience()

        myCVRepository.getExperience()
            .subscribeWith(object : DisposableSingleObserver<List<Experience>>() {
                override fun onSuccess(t: List<Experience>) {
                    Log.d("ExViewModel", "Succes getting experiences ")

                }

                override fun onError(e: Throwable) {
                    Log.d("ExViewModel", "Error message: " + e.message)
                }
            }).addTo(disposableManager.compositeDisposable)
    }

    private fun setList(list: List<Experience>) {
        Log.d("ExVieModel", "List get " + list[0].name)
    }

    private fun onError(error: Throwable) {

        Log.e("ExVieModel", error.message)
    }


    private val _text = MutableLiveData<List<Experience>>().apply {
        value = arrayListOf()
    }

    val text: LiveData<List<Experience>> = _text
}