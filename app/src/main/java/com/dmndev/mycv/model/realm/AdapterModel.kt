package com.dmndev.mycv.model.realm

import com.dmndev.mycv.model.Experience
import com.dmndev.mycv.model.Hobby
import com.dmndev.mycv.model.Knowledge

class AdapterModel (
    var label: String? = null,
    var experience: Experience? = null,
    var knowledge: Knowledge? = null,
    var hobbies: Hobby? = null
)