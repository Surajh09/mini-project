package com.minipro.miniproject11.network

import com.minipro.miniproject11.data.YourDataModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("data")
    fun getData(): Call<List<YourDataModel>>
}