package com.dmndev.mycv.model

import io.realm.RealmObject
import java.util.*

open class Experience : RealmObject() {
    var name: String = ""
    var companyName: String = ""
    var startDate: Date = Date()
    var endDate: Date? = null
    var position: String = ""
}