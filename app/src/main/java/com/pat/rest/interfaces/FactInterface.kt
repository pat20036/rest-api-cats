package com.pat.rest.interfaces

import com.pat.rest.model.CatFactItem
import retrofit2.Call
import retrofit2.http.GET

interface FactInterface {
    @GET("/facts/random")
     fun getFact(): Call<CatFactItem>
}