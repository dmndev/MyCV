package com.dmndev.mycv.model.realm

import com.dmndev.mycv.model.AdapterModel
import com.dmndev.mycv.model.ModelType

open class Knowledge : AdapterModel {
    override val modelType: ModelType =
        ModelType.KNOWLEDGE
    var name: String = ""
    var level: Int = 1
}