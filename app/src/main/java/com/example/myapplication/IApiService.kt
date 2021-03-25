package com.example.myapplication

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.io.IOException

interface MyService{
    @GET("mercy3")
    fun getRawResponseForPosts(): retrofit2.Call<ResponseBody>

    @POST("mercy3")
    fun postRawRequestForPosts(@Body body: Post):retrofit2.Call<ResponseBody>

    @PUT("posts/{id}")
    fun putRawRequestForPosts(@Path("id") id:String, @Body body:RequestBody):retrofit2.Call<ResponseBody>
    @DELETE("posts/{id}")
    fun deletePathParam(@Path("id") id: String):retrofit2.Call<ResponseBody>

}






