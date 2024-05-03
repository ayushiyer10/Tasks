package com.qualflow.webservices

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("users")
    fun getUsers() : Call<List<User>>

}