package com.dmndev.mycv.model.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Experience : RealmObject() {
    @PrimaryKey
    var id: Long = 1L
    var name: String = ""
    var startDate: Date = Date()
    var endDate: Date? = null
    var description: String = ""
}