package com.dmndev.mycv.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.model.realm.Experience

class ExperienceViewModel : ViewModel() {

    var e : Experience = Experience()


    init {
        e.name = "test name"
        e.description = "tetetette etettet et ette tet et tet e et et etettetete tet e tet"
    }

    private val _text = MutableLiveData<List<Experience>>().apply {
        value = arrayListOf(e, e, e, e, e)
    }
    val text: LiveData<List<Experience>> = _text
}