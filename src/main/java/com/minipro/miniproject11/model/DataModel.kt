package com.minipro.miniproject11.model

import com.minipro.miniproject11.data.YourDataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitClientInstance {
    private const val BASE_URL = "http://your-api-url.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("your-endpoint")
    fun fetchData(): Call<List<YourDataModel>> // Adjust the endpoint and return type accordingly
}

//data class DataModel(
//    val id: Int,
//    val name: String,
//    val branch: String
//)
