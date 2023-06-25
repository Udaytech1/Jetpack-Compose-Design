package com.findandhire.data.network_request

import com.findandhire.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConnection {
    fun getInstance(): ApiService {
        return Retrofit.Builder()
            .baseUrl(AppConstants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}