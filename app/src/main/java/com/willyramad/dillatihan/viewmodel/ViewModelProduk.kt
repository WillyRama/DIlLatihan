package com.willyramad.dillatihan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willyramad.dillatihan.modul.ProfukResponItem
import com.willyramad.dillatihan.service.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelProduk @Inject constructor(var api : RestfulApi): ViewModel() {

    lateinit var liveDataProduk :MutableLiveData<List<ProfukResponItem>>

    init {
        liveDataProduk = MutableLiveData()
    }
    fun getLiveDataPro() : MutableLiveData<List<ProfukResponItem>>{
        return liveDataProduk
    }
    fun callApiPro(){
        api.getAllProduk().enqueue(object  : Callback<List<ProfukResponItem>>{
            override fun onResponse(
                call: Call<List<ProfukResponItem>>,
                response: Response<List<ProfukResponItem>>
            ) {
                if (response.isSuccessful){
                    liveDataProduk.postValue(response.body())
                }else{
                    liveDataProduk.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ProfukResponItem>>, t: Throwable) {
                liveDataProduk.postValue(null)
            }

        })
    }
}