package com.pat.rest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pat.rest.CatInterface
import com.pat.rest.model.CatFactItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val catInterface: CatInterface): ViewModel() {

    private val _catFactLiveData = MutableLiveData<CatFactItem>()
    val catFactLiveData: LiveData<CatFactItem> get() = _catFactLiveData

    fun getFact()
    {
           catInterface.provideCatApi().getFact().enqueue(object : Callback<CatFactItem>{
               override fun onResponse(call: Call<CatFactItem>, response: Response<CatFactItem>) {
                   _catFactLiveData.value = response.body()
                   Log.d("qqq", _catFactLiveData.value.toString())
               }

               override fun onFailure(call: Call<CatFactItem>, t: Throwable) {

               }

           })


    }



}