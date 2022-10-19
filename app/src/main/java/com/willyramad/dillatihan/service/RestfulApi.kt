package com.willyramad.dillatihan.service

import com.willyramad.dillatihan.modul.ProfukResponItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {

    @GET("api/v1/products.json")
    fun getAllProduk (): Call<List<ProfukResponItem>>
}