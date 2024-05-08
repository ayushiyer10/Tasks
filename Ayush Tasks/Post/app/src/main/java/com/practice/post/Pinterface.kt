package com.practice.post

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface Pinterface {
    @POST("auth/login")
    fun loginUser(@Body loginUserRequest: LoginUserRequest): Call<LoginUserResponse>

}