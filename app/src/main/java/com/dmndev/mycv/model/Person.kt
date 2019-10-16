package com.dmndev.mycv.model

import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import io.realm.RealmObject

open class Person : RealmObject() {
    var firstName: String = ""
    var sureName: String = ""

    var experiences: List<Experience> = listOf()
    var knowledge: List<Knowledge> = listOf()
}