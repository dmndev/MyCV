package com.dmndev.mycv.model.repository

import com.dmndev.mycv.model.Person
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface RestRepository {
    @GET("")
    fun getPerson() : Observable<Person>

    @GET("")
    fun getExperiences() : Observable<List<Experience>>

    @GET("")
    fun getKnowledge() : Observable<List<Knowledge>>
}