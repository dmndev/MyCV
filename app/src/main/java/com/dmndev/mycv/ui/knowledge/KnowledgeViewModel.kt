package com.dmndev.mycv.ui.knowledge

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.di.Injector
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.model.repository.MyCVRepository
import com.dmndev.mycv.utils.DisposableManager
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class KnowledgeViewModel : ViewModel() {

    @Inject
    lateinit var myCVRepository: MyCVRepository
    @Inject
    lateinit var disposableManager: DisposableManager

    private val _knowledgeList = MutableLiveData<List<Knowledge>>().apply {
        value = arrayListOf()
    }
    val knowledgeList: LiveData<List<Knowledge>> = _knowledgeList

    init {
        Injector.getComponent().inject(this)
        updateAndGetKnowledgeList()
    }

    private fun updateAndGetKnowledgeList() {
        myCVRepository.updateKnowledge()

        myCVRepository.getKnowledge()
            .subscribeWith(object : DisposableObserver<List<Knowledge>>() {
                override fun onComplete() {
                }

                override fun onNext(t: List<Knowledge>) {
                    Log.d("KnowledgeViewModel", "Succes getting knowledge ")
                    _knowledgeList.apply {
                        value = t
                    }
                }

                override fun onError(e: Throwable) {
                    Log.d("KnowViewModel", "Error message: " + e.message)
                }
            }).addTo(disposableManager.compositeDisposable)
    }
}