package com.pat.rest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pat.rest.CatInterface
import com.pat.rest.model.CatFactItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val catInterface: CatInterface): ViewModel() {

    private val _catFactLiveData = MutableLiveData<CatFactItem>()
    val catFactLiveData: LiveData<CatFactItem> get() = _catFactLiveData

    fun getFact() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                _catFactLiveData.postValue(catInterface.provideCatApi().getFact())
            } catch (e: Exception){
                Log.d("e", e.message.toString())
            }

        }
    }



}