package com.pat.rest

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pat.rest.interfaces.FactInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface CatInterface {
    fun provideCatApi(): FactInterface
}

class CatInterfaceImpl() : CatInterface {
   var retrofit: Retrofit = Retrofit.Builder()
      .baseUrl(CAT_API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()

    override fun provideCatApi(): FactInterface {

        return retrofit.create(FactInterface::class.java)
    }

}




