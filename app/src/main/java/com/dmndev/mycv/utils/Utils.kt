package com.dmndev.mycv.utils

import com.dmndev.mycv.model.realm.AdapterModel
import com.dmndev.mycv.model.Person
import java.util.*
import kotlin.collections.ArrayList


fun createListForAdapter(person: Person): ArrayList<AdapterModel> {
    var returnList: ArrayList<AdapterModel> = arrayListOf()
    var adapterModel = AdapterModel(label = "Experience")
    returnList.add(adapterModel)
    person.experiences.forEach { it ->
        returnList.add(AdapterModel(experience = it))
    }

    returnList.add(AdapterModel(label = "Knowledge"))
    person.knowledge.forEach { it ->
        returnList.add(AdapterModel(knowledge = it))
    }

    returnList.add(AdapterModel(label = "Hobby"))
    person.hobbys.forEach { it ->
        returnList.add(AdapterModel(hobbies = it))
    }

    return returnList
}

fun Date.formatToString(): String {
    return "tetttttdata"
}
