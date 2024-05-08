package com.practice.post

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(Pinterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Todo: Identify the condition using which
        // line of code only gets executed in debug mode

        val recyclerView: RecyclerView = findViewById(R.id.cardRecycler)
        adapter = RecyclerAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val loginButton: Button = findViewById(R.id.login)
        loginButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.name).text.toString()
            val password = findViewById<EditText>(R.id.pass).text.toString()

            val request = LoginUserRequest(username, password)
            val call = apiService.loginUser(request)
            call.enqueue(object : Callback<LoginUserResponse> {
                override fun onResponse(
                    call: Call<LoginUserResponse>,
                    response: Response<LoginUserResponse>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            val userList = listOf(body)
                            adapter.updateData(userList)
                        } else {
                            showToast("Response body is null")
                        }
                    } else {
                        showToast("Login failed")
                    }
                }

                override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
                    showToast("Network error")
                }
            })
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
