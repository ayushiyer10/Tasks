package com.practice.post

import com.google.gson.annotations.SerializedName

data class LoginUserRequest(
    @SerializedName("username") val userName: String,
    @SerializedName("password") val password: String
)


