package com.dmndev.mycv.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person : RealmObject() {
    @PrimaryKey var id : Long = 1L
    var firstName: String = ""
    var sureName: String = ""
    var aboutMe: String = ""
}