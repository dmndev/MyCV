package com.dmndev.mycv.model

import io.realm.RealmList
import io.realm.RealmObject

open class Person : RealmObject() {
    var firstName: String = ""
    var sureName: String = ""

    var experiences: RealmList<Experience> = RealmList()
    var knowledge: RealmList<Knowledge> = RealmList()
    var hobbys: RealmList<Hobby> = RealmList()
}