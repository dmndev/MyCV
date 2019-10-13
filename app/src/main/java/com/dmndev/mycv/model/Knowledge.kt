package com.dmndev.mycv.model

import io.realm.RealmObject

open class Knowledge : RealmObject(){
    var name: String = ""
    var level: Int = 1

    enum class LevelOfKnowledge(val level: Int) {
        BASIC(1),
        NOVICE(2),
        INTERMEDIATE(3),
        ADVENCED(4),
        EXPERT(5)
    }
}