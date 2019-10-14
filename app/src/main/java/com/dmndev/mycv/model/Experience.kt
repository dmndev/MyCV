package com.dmndev.mycv.model

import java.util.*

interface Experience {
    var name: String
    var startDate: Date
    var endDate: Date?
    var description: String
}