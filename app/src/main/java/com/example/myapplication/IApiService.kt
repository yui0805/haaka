package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.POST
import java.io.IOException

class IApiService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_api_service)

        interface IApiService{
            @POST("https://beginners-hack-demo2.herokuapp.com/mercy3")
            fun apiDemo(): Call<Info>

        }

        try {
            val response = API.apiDemo().execute()
            if (response.isSuccessful()) {
                return response.body()
            } else {
                // failed
            }
        } catch (e: IOException e) {
            e.printStackTrace()
        }


    }


    data class Info(var title:String,
                    var year:String)
}




