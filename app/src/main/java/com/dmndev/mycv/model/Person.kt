package com.dmndev.mycv.model

import io.realm.RealmList
import io.realm.RealmObject

open class Person  {
    var firstName: String = ""
    var sureName: String = ""

    var experiences: List<Experience> = listOf()
    var knowledge: List<Knowledge> = listOf()
    var hobbys: List<Hobby> = listOf()
}