package com.qualflow.webservices

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.http.POST
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var btnFetch: Button
    private lateinit var btnPOST: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFetch = findViewById(R.id.btnFetch)
        btnPOST = findViewById(R.id.btnPost)
        progressBar = findViewById(R.id.progressbar)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter

        btnFetch.setOnClickListener {
            retrofitInitialisation()
        }


    }

    private fun retrofitInitialisation() {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(p0: Call<List<User>>, p1: Response<List<User>>) {
                if (p1.body() != null) {
                    userAdapter.setUsers(p1.body()!!)
                }
            }

            override fun onFailure(p0: Call<List<User>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Fetch error : ${p1.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }



}