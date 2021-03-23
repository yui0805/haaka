package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.util.concurrent.TimeUnit

class Post_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_test)

        interface IApiService{
            @POST("https://beginners-hack-demo2.herokuapp.com/mercy3")
            fun apiDemo(): Call<com.example.myapplication.IApiService.Info>

        }
        
        val httpBuilder: OkHttpClient.Builder get(){
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()
                    
                    val request = original.newBuilder()
                        .header("accept,"application/json")
                        .method(original.method(),original.body())
                        .build()

                            return@Intercepter chain.proceed(request)
                })
                .readTimeout(30,TimeUnit.SECONDS)3
        }


    }

    // core for controller
    val service: IApiService = create(IApiService::class.java)

    lateinit var retrofit: Retrofit

    fun <S> create(serviceClass: Class<S>): S {
        val gson = GsonBuilder()
            .serializeNulls()
            .create()

        // create retrofit
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://randomuser.me/") // Put your base URL
            .client(httpBuilder.build())
            .build()

        return retrofit.create(serviceClass)
    }



}