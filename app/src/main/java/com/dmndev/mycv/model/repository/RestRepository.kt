package com.dmndev.mycv.model.repository

import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import io.reactivex.Single
import retrofit2.http.GET

interface RestRepository {
    @GET("dmndev/MyCV/person")
    fun getPerson() : Single<Person>

    @GET("dmndev/MyCV/experiences")
    fun getExperiences() : Single<List<Experience>>

    @GET("dmndev/MyCV/knowledge")
    fun getKnowledge() : Single<List<Knowledge>>
}