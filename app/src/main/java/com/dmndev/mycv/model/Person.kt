package com.dmndev.mycv.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person : RealmObject() {
    @PrimaryKey var id : Long = 1L
    var firstName: String = ""
    var lastName: String = ""
    var aboutMe: String = ""
    var email: String = ""
    var phone: String = ""
    var avatarUrl: String = ""
}