package com.dmndev.mycv.model.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Knowledge : RealmObject() {
    @PrimaryKey
    var id: Long = 1L
    var name: String = ""
    var level: Int = 1
}