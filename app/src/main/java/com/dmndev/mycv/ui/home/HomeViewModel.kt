package com.dmndev.mycv.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmndev.mycv.model.*
import com.dmndev.mycv.model.realm.AdapterModel
import com.dmndev.mycv.utils.createListForAdapter
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel : ViewModel() {

    val person = Person()

    init {
        val hobby = Hobby()
        hobby.name = "Test hobby"

        val ex = Experience()
        ex.name = "ex test"
        ex.description = "dessclkcakd;a as;lkd a;skdlksld hjalksjdk ;'fvlask;d iausjhkdjkl"
        ex.startDate = Date(System.currentTimeMillis())
        ex.endDate = Date(System.currentTimeMillis())

        val hobbies = listOf(hobby, hobby,hobby,hobby, hobby)

        val knowledge = Knowledge()
        knowledge.name = "Test knowledge"

        val knowledges = listOf(knowledge,knowledge,knowledge, knowledge)

        val expp = listOf(ex, ex,ex, ex)

        person.experiences = expp
        person.hobbys = hobbies
        person.knowledge = knowledges
    }

    private val _list = MutableLiveData<ArrayList<AdapterModel>>().apply {
        value = createListForAdapter(person)
    }

    var list: LiveData<ArrayList<AdapterModel>> = _list
}