package com.findandhire.data.network_request

import com.findandhire.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(): Call<LoginResponse>
}