package com.dmndev.mycv.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.model.*
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel : ViewModel() {


    private val _list = MutableLiveData<ArrayList<com.dmndev.mycv.model.AdapterModel>>().apply {
        value = arrayListOf()
    }

    var list: LiveData<ArrayList<com.dmndev.mycv.model.AdapterModel>> = _list
}