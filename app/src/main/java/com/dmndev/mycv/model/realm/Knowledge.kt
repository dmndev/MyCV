package com.dmndev.mycv.model.realm

import io.realm.RealmObject

open class Knowledge : RealmObject() {
    var name: String = ""
    var level: Int = 1
}