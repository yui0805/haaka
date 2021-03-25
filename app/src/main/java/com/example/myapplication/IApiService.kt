package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.io.IOException

interface MyService{
    @GET("posts")
    fun getRawResponseForPosts(): retrofit2.Call<ResponseBody>

    @POST("posts")
    fun postRawRequestForPosts(@Body body: RequestBody):retrofit2.Call<ResponseBody>

    @PUT("posts/{id}")
    fun putRawResponseForPosts(@Path("id") id:String,@Body body:ResponseBody):retrofit2.Call<ResponseBody>

    @DELETE("posts/{id}")
    fun deletePathParam(@Path("id") id: String):retrofit2.Call<ResponseBody>

}






