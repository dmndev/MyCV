package com.dmndev.mycv.model

import io.realm.RealmObject
import java.util.*

open class Experience{
    var name: String = ""
    var companyName: String = ""
    var startDate: Date = Date()
    var endDate: Date? = null
    var description: String = ""
}