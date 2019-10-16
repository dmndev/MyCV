package com.dmndev.mycv.model.realm

import io.realm.RealmObject
import java.util.*

open class Experience : RealmObject() {
    var name: String = ""
    var startDate: Date = Date()
    var endDate: Date? = null
    var description: String = ""
}