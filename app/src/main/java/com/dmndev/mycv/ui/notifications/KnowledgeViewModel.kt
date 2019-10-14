package com.dmndev.mycv.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.model.realm.Knowledge

class KnowledgeViewModel : ViewModel() {

    val k = Knowledge()
    val kk = Knowledge()

    init {
        k.name = "aksak"
        k.level = 4
        kk.name = "kk"
        kk.level = 5
    }

    private val _text = MutableLiveData<List<Knowledge>>().apply {
        value = arrayListOf(k, k , k, k , k ,k, k ,k , kk)
    }
    val text: LiveData<List<Knowledge>> = _text
}