package com.dmndev.mycv.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.model.realm.Knowledge

class KnowledgeViewModel : ViewModel() {

    val k = Knowledge()

    init {
        k.name = "aksak"
    }

    private val _text = MutableLiveData<List<Knowledge>>().apply {
        value = arrayListOf(k, k , k, k , k ,k , k ,k )
    }
    val text: LiveData<List<Knowledge>> = _text
}