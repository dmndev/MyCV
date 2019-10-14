package com.dmndev.mycv.model.realm

import com.dmndev.mycv.model.Experience
import java.util.*

open class Experience : Experience {
    override var name: String = ""
    override var startDate: Date = Date()
    override var endDate: Date? = null
    override var description: String = ""
}